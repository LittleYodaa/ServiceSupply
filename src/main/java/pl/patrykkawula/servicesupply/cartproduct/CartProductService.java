package pl.patrykkawula.servicesupply.cartproduct;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.cartproduct.dtos.CartProductViewDto;
import pl.patrykkawula.servicesupply.employee.Employee;
import pl.patrykkawula.servicesupply.employee.EmployeeRepository;
import pl.patrykkawula.servicesupply.employee.EmployeeService;
import pl.patrykkawula.servicesupply.exception.CartProductNotFoundException;
import pl.patrykkawula.servicesupply.exception.EmployeeNotFoundException;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreDtoMapper;
import pl.patrykkawula.servicesupply.store.StoreService;

import java.util.List;

@Service
public class CartProductService {
    private final CartProductRepository cartProductRepository;
    private final ProductDetailsService productDetailsService;
    private final BrandService brandService;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final CartProductDtoMapper cartProductDtoMapper;
    private final StoreDtoMapper storeDtoMapper;
    private final StoreService storeService;


    CartProductService(CartProductRepository cartProductRepository, ProductDetailsService productDetailsService, BrandService brandService, ProductDetailsDtoMapper productDetailsDtoMapper, EmployeeService employeeService, EmployeeRepository employeeRepository, CartProductDtoMapper cartProductDtoMapper, StoreDtoMapper storeDtoMapper, StoreService storeService) {
        this.cartProductRepository = cartProductRepository;
        this.productDetailsService = productDetailsService;
        this.brandService = brandService;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.cartProductDtoMapper = cartProductDtoMapper;
        this.storeDtoMapper = storeDtoMapper;
        this.storeService = storeService;
    }

    public List<CartProductViewDto> findAllCartProducts() {
        return cartProductRepository.findAll()
                .stream()
                .map(cartProductDtoMapper::mapToCartProductViewDto)
                .toList();
    }

    @Transactional
    void addCartProduct(Long id) {
        if (checkStoreProduct(id))
            cartProductRepository.findById(id).ifPresent(cartProduct -> cartProduct.setProductQuantity(cartProduct.getProductQuantity() + 1));
        else {
            ProductDetailsSaveDto productDetailsById = productDetailsService.findProductDetailsById(id);
            Brand brand = brandService.findByName(productDetailsById.brand());
            Store store = storeDtoMapper.map(storeService.getActualEmployeeStore());
            ProductDetails productDetails = productDetailsDtoMapper.map(productDetailsById, brand);
            Long actualEmployeeId = employeeService.getActualEmployeeId();
            Employee employee = employeeRepository.findById(actualEmployeeId).orElseThrow(() -> new EmployeeNotFoundException(actualEmployeeId));
            addNewCartProduct(id, productDetails, employee, store);
        }
    }

    @Transactional
    void deleteCartProduct(Long id) {
        Long cartProductQuantity = cartProductRepository.findById(id).map(CartProduct::getProductQuantity).orElseThrow(() -> new CartProductNotFoundException(id));
        if (cartProductQuantity >= 2)
            cartProductRepository.findById(id).ifPresent(cartProduct -> cartProduct.setProductQuantity(cartProduct.getProductQuantity() - 1));
        else
            cartProductRepository.deleteById(id);
    }

    private void addNewCartProduct(Long id, ProductDetails productDetails, Employee employee, Store store) {
        cartProductRepository.save(new CartProduct(id, 1L, productDetails, employee, store));
    }

    private boolean checkStoreProduct(Long id) {
        return cartProductRepository.findById(id).isPresent();
    }
}
