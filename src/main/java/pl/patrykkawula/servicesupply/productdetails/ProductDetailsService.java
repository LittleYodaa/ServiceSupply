package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.exception.ProductDetailsNotFoundException;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

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
                .map(productDetailsDtoMapper::mapToProductDetailsDto)
                .toList();
    }

    void saveProductDetails(ProductDetailsSaveDto productDetailsSaveDto){
        productDetailsRepository.save(productDetailsDtoMapper.map(productDetailsSaveDto));
    }

    ProductDetailsSaveDto findProductDetailsById(Long id) {
       return productDetailsRepository.findById(id).
               map(productDetailsDtoMapper::mapToProductDetailsSaveDto).
               orElseThrow(() -> new ProductDetailsNotFoundException(id));
    }
}
