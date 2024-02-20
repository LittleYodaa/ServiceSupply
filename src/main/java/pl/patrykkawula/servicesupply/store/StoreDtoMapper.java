package pl.patrykkawula.servicesupply.store;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

@Service
public class StoreDtoMapper {

    public StoreDto mapToStoreDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .build();
    }

    public Store map(StoreDto storeDto) {
        return Store.builder()
                .id(storeDto.id())
                .name(storeDto.name())
                .build();
    }
}
