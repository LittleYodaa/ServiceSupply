package pl.patrykkawula.servicesupply.productdetails.dtos;

import lombok.Builder;

@Builder
public record ProductDetailsDto(
        Long id,
        String brand,
        String name) {
}
