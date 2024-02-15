package pl.patrykkawula.servicesupply.brand;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.dtos.BrandNameDto;

@Service
public class BrandDtoMapper {

    public BrandNameDto mapToBrandNameDto(Brand brand) {
        return BrandNameDto.builder()
                .name(brand.getName())
                .build();
    }
}
