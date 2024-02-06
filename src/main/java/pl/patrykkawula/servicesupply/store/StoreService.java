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

    public Store findStoreByName(String name) {
        return storeRepository.findByName(name).orElseThrow(() -> new StoreNotFoundException(name));
    }

    public Store findStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException(id));
    }

    public List<StoreDto> getAllStores() {
        return storeRepository.findAll()
                .stream()
                .map(storeDtoMapper::mapToStoreDto)
                .toList();
    }

    //todo
    //przykładowo getAllStores zwraca listę dto bo to idzie do widoku ale reszta metod zwraca encję, bo idę do tworzenia
    //obiektów i nie wychodzą na widok, może tak być?
}
