package pl.patrykkawula.servicesupply.brand;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.patrykkawula.servicesupply.exception.BrandNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name).orElseThrow(() -> new BrandNotFoundException(name));
    }

    public List<String> getAllBrandName(){
        return brandRepository.findAll().stream()
                .map(Brand::getName)
                .toList();
    }
}
