package pl.patrykkawula.servicesupply.employee.dtos;

import lombok.Builder;

@Builder
public record EmployeeViewDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        Long storeId) {
}
