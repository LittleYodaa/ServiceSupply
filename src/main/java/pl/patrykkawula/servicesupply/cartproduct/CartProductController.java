package pl.patrykkawula.servicesupply.cartproduct;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patrykkawula.servicesupply.cartproduct.dtos.CartProductViewDto;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsDtoMapper;
import pl.patrykkawula.servicesupply.productdetails.ProductDetailsService;

import java.util.List;

@Controller
@RequestMapping("/cartProducts")
class CartProductController {
    private final ProductDetailsService productDetailsService;
    private final CartProductService cartProductService;

    CartProductController(ProductDetailsService productDetailsService, CartProductService cartProductService) {
        this.productDetailsService = productDetailsService;
        this.cartProductService = cartProductService;
    }

    @GetMapping
    String findAllCartProduct(Model model) {
        List<CartProductViewDto> cartProductsList = cartProductService.findAllCartProducts();
        model.addAttribute("cartProductsList", cartProductsList);
        return "cart_product";
    }
    @GetMapping("{id}/addCartProduct")
    String addCartProduct(@PathVariable(value = "id") Long id) {
        cartProductService.addCartProduct(id);
        return "redirect:/cartProducts";
    }
}
