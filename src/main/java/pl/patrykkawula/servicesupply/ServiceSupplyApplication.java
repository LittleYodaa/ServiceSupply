package pl.patrykkawula.servicesupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class ServiceSupplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSupplyApplication.class, args);
	}

}
