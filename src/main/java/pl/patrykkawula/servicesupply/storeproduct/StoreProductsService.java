package pl.patrykkawula.servicesupply.storeproduct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.employee.EmployeeService;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeStoreDto;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsRepository;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreDtoMapper;
import pl.patrykkawula.servicesupply.store.StoreService;
import pl.patrykkawula.servicesupply.storeproduct.dtos.StoreProductViewDto;

import java.util.List;

@Service
class StoreProductsService {
    private final StoreProductRepository storeProductRepository;
    private final ProductDetailsService productDetailsService;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    private final BrandService brandService;
    private final EmployeeService employeeService;
    private final StoreService storeService;
    private final StoreDtoMapper storeDtoMapper;
    private final ProductDetailsRepository productDetailsRepository;

    StoreProductsService(StoreProductRepository storeProductRepository, ProductDetailsService productDetailsService, ProductDetailsDtoMapper productDetailsDtoMapper, BrandService brandService, EmployeeService employeeService, StoreService storeService, StoreDtoMapper storeDtoMapper, ProductDetailsRepository productDetailsRepository) {
        this.storeProductRepository = storeProductRepository;
        this.productDetailsService = productDetailsService;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.brandService = brandService;
        this.employeeService = employeeService;
        this.storeService = storeService;
        this.storeDtoMapper = storeDtoMapper;
        this.productDetailsRepository = productDetailsRepository;
    }

    public List<StoreProductViewDto> createStoreProductDtoListFromProductDetails() {
        return productDetailsService.findAllProductsDetails()
                .stream()
                .map(productDetailsDto -> new StoreProductViewDto(checkStoreProductQuantity(productDetailsDto), productDetailsDto.brand(), productDetailsDto.name()))
                .toList();
    }

    @Transactional
    public void deleteStoreProduct(StoreProductViewDto storeProductViewDto) {
        ProductDetails productDetails = getActualProductDetailsByName(storeProductViewDto);
        Store store = getActualUsersStore();
        if (storeProductViewDto.quantity() == 0)
            ;
        else
            storeProductRepository.findByProductDetailsAndStore(productDetails, store)
                    .ifPresent(storeProduct -> storeProduct.setProductQuantity(storeProduct.getProductQuantity() - 1));

    }

    @Transactional
    void saveStoreProduct(StoreProductViewDto storeProductViewDto) {
        if (checkIfStoreProductExist(storeProductViewDto))
            storeProductRepository.findByProductDetailsAndStore(getActualProductDetailsByName(storeProductViewDto), getActualUsersStore())
                    .ifPresent(storeProduct -> storeProduct.setProductQuantity(storeProduct.getProductQuantity() + 1));
        else
            addNewStoreProduct(storeProductViewDto);
    }

    void addNewStoreProduct(StoreProductViewDto storeProductViweDto) {
        ProductDetails productDetails = getActualProductDetailsByName(storeProductViweDto);
        StoreProduct storeProduct = StoreProduct.builder()
                .productQuantity(1L)
                .store(getActualUsersStore())
                .productDetails(productDetails)
                .build();
        storeProductRepository.save(storeProduct);
    }

    private boolean checkIfStoreProductExist(StoreProductViewDto storeProductViewDto) {
        return storeProductRepository
                .findByProductDetailsAndStore(getActualProductDetailsByName(storeProductViewDto),
                        getActualUsersStore()).isPresent();
    }

    private Long checkStoreProductQuantity(ProductDetailsDto productDetailsDto) {
        return storeProductRepository.findByProductDetailsAndStore(getActualProductDetails(productDetailsDto), getActualUsersStore())
                .map(StoreProduct::getProductQuantity)
                .orElse(0L);
    }

    private Store getActualUsersStore() {
        EmployeeStoreDto employeeStoreDto = employeeService.getActualEmployeeStoreDto();
        return storeDtoMapper.map(storeService.findStoreById(employeeStoreDto.storeId()));
    }

    private ProductDetails getActualProductDetails(ProductDetailsDto productDetailsDto) {
        return productDetailsDtoMapper
                .map(productDetailsService.findProductDetailsById(productDetailsDto.id()),
                        brandService.findByName(productDetailsDto.brand()));
    }

    private Brand getActualBrandByName(String brand) {
        return brandService.findByName(brand);
    }

    private ProductDetails getActualProductDetailsByName(StoreProductViewDto storeProductViewDto) {
        return productDetailsDtoMapper.map(productDetailsService.findProductDetailsByName(storeProductViewDto.name()), getActualBrandByName(storeProductViewDto.brand()));
    }
}
