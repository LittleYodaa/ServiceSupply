package pl.patrykkawula.servicesupply.store;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.exception.StoreNotFoundException;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final StoreDtoMapper storeDtoMapper;

    StoreService(StoreRepository storeRepository, StoreDtoMapper storeDtoMapper) {
        this.storeRepository = storeRepository;
        this.storeDtoMapper = storeDtoMapper;
    }

    public StoreDto findStoreByName(String name) {
        return storeRepository.findByName(name)
                .map(storeDtoMapper::mapToStoreDto)
                .orElseThrow(() -> new StoreNotFoundException(name));
    }

    public List<StoreDto> getAllStores() {
        return storeRepository.findAll()
                .stream()
                .map(storeDtoMapper::mapToStoreDto)
                .toList();
    }
}
