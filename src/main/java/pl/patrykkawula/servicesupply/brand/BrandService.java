package pl.patrykkawula.servicesupply.brand;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.dtos.BrandDtoMapper;
import pl.patrykkawula.servicesupply.brand.dtos.BrandNameDto;
import pl.patrykkawula.servicesupply.exception.BrandNotFoundException;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandDtoMapper brandDtoMapper;

    BrandService(BrandRepository brandRepository, BrandDtoMapper brandDtoMapper) {
        this.brandRepository = brandRepository;
        this.brandDtoMapper = brandDtoMapper;
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(() -> new BrandNotFoundException(name));
    }

    public List<BrandNameDto> getAllBrandName(){
        return brandRepository.findAll().stream()
                .map(brandDtoMapper::mapToBrandNameDto)
                .toList();
    }
}
