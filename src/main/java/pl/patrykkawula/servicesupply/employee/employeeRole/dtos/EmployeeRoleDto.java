package pl.patrykkawula.servicesupply.employee.employeeRole.dtos;

import lombok.Builder;

@Builder
public record EmployeeRoleDto(
        Long id,
        String name) {
}
