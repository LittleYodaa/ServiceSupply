package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

@Service
public class ProductDetailsDtoMapper {

    ProductDetailsDto mapToProductDetailsDto(ProductDetails productDetails) {
        Long id = productDetails.getId();
        String brand = productDetails.getBrandName();
        String name = productDetails.getName();
        return new ProductDetailsDto(id, brand, name);
    }

    public ProductDetails map(ProductDetailsSaveDto productDetailsSaveDto, Brand brand) {
        return ProductDetails.builder()
                .id(productDetailsSaveDto.id())
                .brand(brand)
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
}
