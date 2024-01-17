package pl.patrykkawula.servicesupply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class TemporaryController {

    @GetMapping("/")
    String helloService() {
        return "index.html";
    }
}
