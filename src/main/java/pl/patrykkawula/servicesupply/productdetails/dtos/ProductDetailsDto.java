package pl.patrykkawula.servicesupply.productdetails.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
public record ProductDetailsDto(
        Long id,
        String brand,
        String name) {
}
