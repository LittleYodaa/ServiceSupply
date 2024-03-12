package pl.patrykkawula.servicesupply.cartproduct;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.cartproduct.dtos.CartProductViewDto;
import pl.patrykkawula.servicesupply.employee.Employee;
import pl.patrykkawula.servicesupply.employee.EmployeeRepository;
import pl.patrykkawula.servicesupply.employee.EmployeeService;
import pl.patrykkawula.servicesupply.exception.EmployeeNotFoundException;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

import java.util.List;

@Service
class CartProductService {
    private final CartProductRepository cartProductRepository;
    private final ProductDetailsService productDetailsService;
    private final BrandService brandService;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final CartProductDtoMapper cartProductDtoMapper;

    CartProductService(CartProductRepository cartProductRepository, ProductDetailsService productDetailsService, BrandService brandService, ProductDetailsDtoMapper productDetailsDtoMapper, EmployeeService employeeService, EmployeeRepository employeeRepository, CartProductDtoMapper cartProductDtoMapper) {
        this.cartProductRepository = cartProductRepository;
        this.productDetailsService = productDetailsService;
        this.brandService = brandService;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.cartProductDtoMapper = cartProductDtoMapper;
    }

    List<CartProductViewDto> findAllCartProducts() {
        return cartProductRepository.findAll()
                .stream()
                .map(cartProductDtoMapper::mapToCartProductViewDto)
                .toList();
    }

    @Transactional
    void addCartProduct(Long id) {
        ProductDetailsSaveDto productDetailsById = productDetailsService.findProductDetailsById(id);
        Brand brand = brandService.findByName(productDetailsById.brand());
        ProductDetails productDetails = productDetailsDtoMapper.map(productDetailsById, brand);
        Long actualEmployeeId = employeeService.getActualEmployeeId();
        Employee employee = employeeRepository.findById(actualEmployeeId).orElseThrow(() -> new EmployeeNotFoundException(actualEmployeeId));
        if (checkStoreProduct(id))
            cartProductRepository.findById(id).ifPresent(cartProduct -> cartProduct.setProductQuantity(cartProduct.getProductQuantity() + 1));
        else
            addNewCartProduct(id, productDetails, employee);
    }

    private void addNewCartProduct(Long id, ProductDetails productDetails, Employee employee) {
        cartProductRepository.save(new CartProduct(id, 1L, productDetails, employee));
    }

    private boolean checkStoreProduct(Long id) {
        return cartProductRepository.findById(id).isPresent();
    }
}
