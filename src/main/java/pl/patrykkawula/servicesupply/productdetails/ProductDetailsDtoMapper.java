package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;

@Service
class ProductDetailsDtoMapper {
    ProductDetailsDto map(ProductDetails productDetails) {
        String brand = productDetails.getBrandName();
        String name = productDetails.getName();
        return new ProductDetailsDto(brand, name);
    }
}
