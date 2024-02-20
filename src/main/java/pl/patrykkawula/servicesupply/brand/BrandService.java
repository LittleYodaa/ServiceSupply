package pl.patrykkawula.servicesupply.brand;

import org.springframework.stereotype.Service;
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

    // FIXME encje nie powinny być udostępniane poza seris
    // no i tu się zastanawiam, ta encja nie wychodzi poza warstwę serwisów bo idzie tylko do ProductDetailsService,
    // trzeba w tym przypadku wysyłać tam obiekt dto i już po stronie productDetails mapować go do encji?
    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(() -> new BrandNotFoundException(name));
    }

    public List<BrandNameDto> getAllBrandName(){
        return brandRepository.findAll().stream()
                .map(brandDtoMapper::mapToBrandNameDto)
                .toList();
    }
}
