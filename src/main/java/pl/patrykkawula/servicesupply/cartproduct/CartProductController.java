package pl.patrykkawula.servicesupply.cartproduct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;

@Controller("/cartProducts")
class CartProductController {
    private final CartProductRepository cartProductRepository;
    private final ProductDetailsService productDetailsService;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;

    CartProductController(CartProductRepository cartProductRepository, ProductDetailsService productDetailsService) {
        this.cartProductRepository = cartProductRepository;
        this.productDetailsService = productDetailsService;
    }
    @GetMapping("{id}/addCartProduct")
    String addCartProduct(@PathVariable(value = "id") Long id) {
        productDetailsDtoMapper.map(productDetailsService.findProductDetailsById(id));
    }
}
