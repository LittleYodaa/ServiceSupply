package pl.patrykkawula.servicesupply.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ControllerAdvisor {

    @ExceptionHandler(ServiceSupplyException.class)
    public String handle(HttpServletRequest request,
                         ServiceSupplyException exception, Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        return "default_error_view";
    }
}
