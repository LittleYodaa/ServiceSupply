package pl.patrykkawula.servicesupply.cartproduct.dtos;

import lombok.Builder;

@Builder
public record CartProductViewDto (
        Long id,
        String productDetailsName,
        Long productQuantity) {
}
