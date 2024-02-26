package pl.patrykkawula.servicesupply.storeproduct.dtos;

import lombok.Builder;

@Builder
public record StoreProductViewDto(
        Long quantity,
        String brand,
        String name) {
}
