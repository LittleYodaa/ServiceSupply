package pl.patrykkawula.servicesupply.productdetails.dtos;

import lombok.Builder;
import pl.patrykkawula.servicesupply.Brand;

@Builder
public record ProductDetailsDto(String brand, String name) {
}
