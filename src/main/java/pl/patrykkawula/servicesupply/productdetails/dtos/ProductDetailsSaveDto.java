package pl.patrykkawula.servicesupply.productdetails.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ProductDetailsSaveDto(
        Long id,
        @NotBlank(message = "Wybierz dostawcę produktu")
        String brand,
        @NotBlank
        @Size(min = 1, max = 200, message = "Nazwa produktu nie może być pusta")
        String name,
        String link,
        String safetyData,
        String gama,
        String code) {
}
