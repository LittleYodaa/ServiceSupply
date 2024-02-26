package pl.patrykkawula.servicesupply.storeproduct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.patrykkawula.servicesupply.storeproduct.dtos.StoreProductViewDto;

import java.util.List;

@Controller
@RequestMapping("/storeProducts")
class StoreProductController {
    private final StoreProductsService storeProductsService;

    StoreProductController(StoreProductsService storeProductsService) {
        this.storeProductsService = storeProductsService;
    }

    @GetMapping
    String findAllStoreProducts(Model model) {
        List<StoreProductViewDto> storeProducts = storeProductsService.createStoreProductDtoListFromProductDetails();
        model.addAttribute("storeProducts", storeProducts);
        return "store_products";
    }

    @PostMapping("/addStoreProduct")
    String addStoreProduct(@ModelAttribute("storeProductDto") StoreProductViewDto storeProductViewDto) {
        storeProductsService.saveStoreProduct(storeProductViewDto);
        return "redirect:/storeProducts";
    }

    @PostMapping("/deleteStoreProduct")
    String deleteStoreProduct(@ModelAttribute("storeProductDto") StoreProductViewDto storeProductViewDto) {
        storeProductsService.deleteStoreProduct(storeProductViewDto);
        return "redirect:/storeProducts";
    }
}
