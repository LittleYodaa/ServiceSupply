package pl.patrykkawula.servicesupply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String home() {
        return "index.html";
    }

    @GetMapping("/workInProgress")
    String workInProgeress() {
        return "functionality_in_progress";
    }
}
