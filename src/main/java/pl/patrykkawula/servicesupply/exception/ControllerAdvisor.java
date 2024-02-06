package pl.patrykkawula.servicesupply.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class ControllerAdvisor {

    @ExceptionHandler(ProductDetailsNotFoundException.class)
    public String handle(HttpServletRequest request,
                               ProductDetailsNotFoundException exception, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        return "errorView/default_error_view";
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public String handle(HttpServletRequest request,
                         BrandNotFoundException exception, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        return "errorView/default_error_view";
    }

    @ExceptionHandler(StoreNotFoundException.class)
    public String handle(HttpServletRequest request,
                         StoreNotFoundException exception, Model model) {
        ModelAndView mav = new ModelAndView();
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        return "errorView/default_error_view";
    }
}
