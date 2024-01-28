package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeCredentialsDto;

import java.util.List;

@Service
class EmployeeCredentialsDtoMapper {

    EmployeeCredentialsDto map(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();
        List<String> roles = employee.getRoles()
                .stream()
                .map(EmployeeRole::getName)
                .toList();
        return new EmployeeCredentialsDto(email, password, roles);
    }
}