package pl.patrykkawula.servicesupply.picture;

import lombok.*;

@Builder
public record Picture(
        String name,
        String fileName) {
}