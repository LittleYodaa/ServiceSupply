package pl.patrykkawula.servicesupply.store;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

@Service
class StoreDtoMapper {

    StoreDto mapToStoreDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .build();
    }
}
