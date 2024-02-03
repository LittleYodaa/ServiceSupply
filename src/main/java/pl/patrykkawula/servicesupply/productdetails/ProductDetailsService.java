package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.exception.ProductDetailsNotFoundException;
import pl.patrykkawula.servicesupply.picture.Picture;
import pl.patrykkawula.servicesupply.picture.PictureRepository;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

import java.util.List;

@Service
class ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    private final PictureRepository pictureRepository;

    ProductDetailsService(ProductDetailsRepository productDetailsRepository, ProductDetailsDtoMapper productDetailsDtoMapper, PictureRepository pictureRepository) {
        this.productDetailsRepository = productDetailsRepository;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.pictureRepository = pictureRepository;
    }

    List<ProductDetailsDto> findAllProductsDetails() {
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

    void deleteProductDetailsById(Long id) {
        productDetailsRepository.deleteById(id);
    }

    Picture productImage(String brand) {
        return pictureRepository.findImageByName(brand);
    }
}
