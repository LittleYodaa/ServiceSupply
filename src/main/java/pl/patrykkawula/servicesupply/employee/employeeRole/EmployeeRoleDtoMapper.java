package pl.patrykkawula.servicesupply.employee.employeeRole;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.employeeRole.dtos.EmployeeRoleDto;

@Service
public class EmployeeRoleDtoMapper {
    EmployeeRoleDto mapToEmployeeRoleNameDto(EmployeeRole employeeRole) {
        return EmployeeRoleDto.builder()
                .id(employeeRole.getId())
                .name(employeeRole.getName())
                .build();
    }

    public EmployeeRole map(EmployeeRoleDto employeeRoleDto) {
        return EmployeeRole.builder()
                .id(employeeRoleDto.id())
                .name(employeeRoleDto.name())
                .build();
    }
}
