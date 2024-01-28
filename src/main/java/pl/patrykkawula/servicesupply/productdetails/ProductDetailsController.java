package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;

import java.util.List;

@Controller
@RequestMapping(("/product-details"))
class ProductDetailsController {
    private final ProductDetailsService productDetailsService;

    ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @GetMapping("/")
    String getAllProductDetails(Model model) {
        List<ProductDetailsDto> productDetailsList = productDetailsService.allProductDetails();
        model.addAttribute("productDetailsList", productDetailsList);
        return "productdetails.html";
    }
}
