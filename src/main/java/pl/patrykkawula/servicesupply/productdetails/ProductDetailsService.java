package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;

import java.util.List;

@Service
class ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;

    ProductDetailsService(ProductDetailsRepository productDetailsRepository, ProductDetailsDtoMapper productDetailsDtoMapper) {
        this.productDetailsRepository = productDetailsRepository;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
    }

    List<ProductDetailsDto> allProductDetails() {
        return productDetailsRepository.findAll()
                .stream()
                .map(productDetailsDtoMapper::map)
                .toList();
    }
}
