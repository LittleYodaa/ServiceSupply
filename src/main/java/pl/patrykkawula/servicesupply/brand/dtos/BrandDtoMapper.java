package pl.patrykkawula.servicesupply.brand.dtos;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;

@Service
public class BrandDtoMapper {

    public BrandNameDto mapToBrandNameDto(Brand brand) {
        return BrandNameDto.builder()
                .name(brand.getName())
                .build();
    }
}
