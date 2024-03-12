package pl.patrykkawula.servicesupply.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/workInProgress")
    String workInProgeress() {
        return "functionality_in_progress";
    }

    @GetMapping("/login")
    String loginForm() {
        return "login_form";
    }
}
