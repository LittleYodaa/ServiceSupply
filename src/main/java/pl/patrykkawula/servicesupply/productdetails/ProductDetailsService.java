package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
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
    private final BrandService brandService;

    ProductDetailsService(ProductDetailsRepository productDetailsRepository, ProductDetailsDtoMapper productDetailsDtoMapper, PictureRepository pictureRepository, BrandService brandService) {
        this.productDetailsRepository = productDetailsRepository;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.pictureRepository = pictureRepository;
        this.brandService = brandService;
    }

    List<ProductDetailsDto> findAllProductsDetails() {
        return productDetailsRepository.findAll()
                .stream()
                .map(productDetailsDtoMapper::mapToProductDetailsDto)
                .toList();
    }

    void saveProductDetails(ProductDetailsSaveDto productDetailsSaveDto){
        Brand brand = brandService.findByName(productDetailsSaveDto.brand());
        productDetailsRepository.save(productDetailsDtoMapper.map(productDetailsSaveDto, brand));
    }

    ProductDetailsSaveDto findProductDetailsById(Long id) {
       return productDetailsRepository.findById(id).
               map(productDetailsDtoMapper::mapToProductDetailsSaveDto).
               orElseThrow(() -> new ProductDetailsNotFoundException(id));
    }

    void deleteProductDetailsById(Long id) {
        productDetailsRepository.deleteById(id);
    }

    Picture findProductImage(String brand) {
        return pictureRepository.findImageByName(brand);
    }
}
