package pl.patrykkawula.servicesupply.employee.dtos;

import lombok.Builder;

@Builder
public record EmployeeStoreDto(
        Long id,
        String email,
        Long storeId) {
}
