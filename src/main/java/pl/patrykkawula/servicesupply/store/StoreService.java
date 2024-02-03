package pl.patrykkawula.servicesupply.store;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.exception.StoreNotFoundException;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store findStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException(id));
    }

    //addAdvisorExceptionPattern
}
