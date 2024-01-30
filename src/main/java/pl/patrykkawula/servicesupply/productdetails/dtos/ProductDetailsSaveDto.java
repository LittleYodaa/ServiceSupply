package pl.patrykkawula.servicesupply.productdetails.dtos;

import lombok.Builder;

@Builder
public record ProductDetailsSaveDto(
        Long id,
        String brand,
        String name,
        String link,
        String safetyData,
        String gama,
        String code) {
}
