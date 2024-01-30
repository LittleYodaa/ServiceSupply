package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

@Service
class ProductDetailsDtoMapper {
    private final BrandService brandService;
    ProductDetailsDtoMapper(BrandService brandService) {
        this.brandService = brandService;
    }

    ProductDetailsDto mapToProductDetailsDto(ProductDetails productDetails) {
        Long id = productDetails.getId();
        String brand = productDetails.getBrandName();
        String name = productDetails.getName();
        return new ProductDetailsDto(id, brand, name);
    }

    ProductDetails map(ProductDetailsSaveDto productDetailsSaveDto) {
        return ProductDetails.builder()
                .id(productDetailsSaveDto.id())
                .brand(findByName(productDetailsSaveDto.brand()))
                .name(productDetailsSaveDto.name())
                .link(productDetailsSaveDto.link())
                .safetyData(productDetailsSaveDto.safetyData())
                .gama(productDetailsSaveDto.gama())
                .code(productDetailsSaveDto.code())
                .build();
    }

    ProductDetailsSaveDto mapToProductDetailsSaveDto(ProductDetails productDetails) {
        return ProductDetailsSaveDto.builder()
                .id(productDetails.getId())
                .brand(productDetails.getBrandName())
                .name(productDetails.getName())
                .link(productDetails.getLink())
                .safetyData(productDetails.getSafetyData())
                .gama(productDetails.getGama())
                .code(productDetails.getCode())
                .build();
    }

    private Brand findByName(String name) {
        return brandService.findByName(name);
    }
}
