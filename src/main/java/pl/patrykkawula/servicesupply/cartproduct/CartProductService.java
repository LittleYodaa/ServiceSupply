package pl.patrykkawula.servicesupply.cartproduct;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreDtoMapper;
import pl.patrykkawula.servicesupply.store.StoreService;

@Service
class CartProductService {
    private final CartProductRepository cartProductRepository;
    private final ProductDetailsService productDetailsService;
    private final BrandService brandService;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;

    CartProductService(CartProductRepository cartProductRepository, ProductDetailsService productDetailsService, BrandService brandService, ProductDetailsDtoMapper productDetailsDtoMapper) {
        this.cartProductRepository = cartProductRepository;
        this.productDetailsService = productDetailsService;
        this.brandService = brandService;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
    }

//    void addCartProduct(Long id) {
//        ProductDetailsSaveDto productDetailsById = productDetailsService.findProductDetailsById(id);
//        Brand brand = brandService.findByName(productDetailsById.brand());
//        ProductDetails productDetails = productDetailsDtoMapper.map(productDetailsById, brand);
//        if (checkStoreProduct(id))
//            cartProductRepository.findById(id).ifPresent(cartProduct -> cartProduct.setProductQuantity(cartProduct.getProductQuantity() + 1));
//        else
//            addNewCartProduct(id, productDetails);
//    }

//    private void addNewCartProduct(Long id, ProductDetails productDetails) {
//        cartProductRepository.save(new CartProduct(id, 1L, productDetails,))
//    }

    private boolean checkStoreProduct(Long id) {
        return cartProductRepository.findById(id).isPresent();
    }
}
