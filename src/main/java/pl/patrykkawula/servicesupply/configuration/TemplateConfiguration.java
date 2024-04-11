package pl.patrykkawula.servicesupply.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
class TemplateConfiguration {
    @Bean
    public ClassLoaderTemplateResolver productDetailsTemplateResolver() {
        ClassLoaderTemplateResolver productDetailsTemplateResolver = new ClassLoaderTemplateResolver();
        productDetailsTemplateResolver.setPrefix("productDetails/");
        productDetailsTemplateResolver.setSuffix(".html");
        productDetailsTemplateResolver.setTemplateMode(TemplateMode.HTML);
        productDetailsTemplateResolver.setCharacterEncoding("UTF-8");
        productDetailsTemplateResolver.setOrder(1);
        productDetailsTemplateResolver.setCheckExistence(true);
        return productDetailsTemplateResolver;
    }

    @Bean
    public ClassLoaderTemplateResolver employeeTemplateResolver() {
        ClassLoaderTemplateResolver productDetailsTemplateResolver = new ClassLoaderTemplateResolver();
        productDetailsTemplateResolver.setPrefix("employee/");
        productDetailsTemplateResolver.setSuffix(".html");
        productDetailsTemplateResolver.setTemplateMode(TemplateMode.HTML);
        productDetailsTemplateResolver.setCharacterEncoding("UTF-8");
        productDetailsTemplateResolver.setOrder(1);
        productDetailsTemplateResolver.setCheckExistence(true);
        return productDetailsTemplateResolver;
    }

    @Bean
    public ClassLoaderTemplateResolver errorViewTemplateResolver() {
        ClassLoaderTemplateResolver productDetailsTemplateResolver = new ClassLoaderTemplateResolver();
        productDetailsTemplateResolver.setPrefix("errorView/");
        productDetailsTemplateResolver.setSuffix(".html");
        productDetailsTemplateResolver.setTemplateMode(TemplateMode.HTML);
        productDetailsTemplateResolver.setCharacterEncoding("UTF-8");
        productDetailsTemplateResolver.setOrder(1);
        productDetailsTemplateResolver.setCheckExistence(true);
        return productDetailsTemplateResolver;
    }

    @Bean
    public ClassLoaderTemplateResolver storeProductsTemplateResolver() {
        ClassLoaderTemplateResolver productDetailsTemplateResolver = new ClassLoaderTemplateResolver();
        productDetailsTemplateResolver.setPrefix("storeProducts/");
        productDetailsTemplateResolver.setSuffix(".html");
        productDetailsTemplateResolver.setTemplateMode(TemplateMode.HTML);
        productDetailsTemplateResolver.setCharacterEncoding("UTF-8");
        productDetailsTemplateResolver.setOrder(1);
        productDetailsTemplateResolver.setCheckExistence(true);
        return productDetailsTemplateResolver;
    }

    @Bean
    public ClassLoaderTemplateResolver cartProductTemplateResolver() {
        ClassLoaderTemplateResolver productDetailsTemplateResolver = new ClassLoaderTemplateResolver();
        productDetailsTemplateResolver.setPrefix("cartProduct/");
        productDetailsTemplateResolver.setSuffix(".html");
        productDetailsTemplateResolver.setTemplateMode(TemplateMode.HTML);
        productDetailsTemplateResolver.setCharacterEncoding("UTF-8");
        productDetailsTemplateResolver.setOrder(1);
        productDetailsTemplateResolver.setCheckExistence(true);
        return productDetailsTemplateResolver;
    }
}
