package pl.patrykkawula.servicesupply.employee.dtos;

import lombok.Builder;

@Builder
public record EmployeeStoreDto(
        String email,
        Long storeId) {
}
