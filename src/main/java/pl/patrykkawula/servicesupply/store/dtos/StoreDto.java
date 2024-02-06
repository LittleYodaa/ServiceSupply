package pl.patrykkawula.servicesupply.store.dtos;

import lombok.Builder;

@Builder
public record StoreDto (
        Long id,
        String name){
}
