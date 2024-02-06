package pl.patrykkawula.servicesupply.employee.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record EmployeeCredentialsDto(
        String email,
        String password,
        List<String> roles){

}
