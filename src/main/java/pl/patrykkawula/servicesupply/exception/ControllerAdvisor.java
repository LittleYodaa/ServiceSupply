package pl.patrykkawula.servicesupply.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
class ControllerAdvisor {

    @ExceptionHandler({ Exception.class})
    public String handle(HttpServletRequest request,
                         Exception exception, Model model) {
        log.error("Exception occurred", exception);
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        return "default_error_view";
    }
//    @ExceptionHandler(Exception.class)
//    public String handle(HttpServletRequest request,
//                         Exception exception, Model model) {
//        log.error("Exception occurred", exception);
//        model.addAttribute("exception", exception);
//        model.addAttribute("url", request.getRequestURL());
//        return "default_error_view";
//    }
}
