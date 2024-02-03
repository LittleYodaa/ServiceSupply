package pl.patrykkawula.servicesupply.employee.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record EmployeeSaveDto(
        String firstName,
        String lastName,
        String email,
        String password,
        Long storeId,
        Long roleId) {
}
