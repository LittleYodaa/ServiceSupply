package pl.patrykkawula.servicesupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Locale;

@SpringBootApplication
public class ServiceSupplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSupplyApplication.class, args);
	}

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
}
