package pl.patrykkawula.servicesupply.brand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brands")
class BrandController {
    private final BrandService brandService;

    BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

}
