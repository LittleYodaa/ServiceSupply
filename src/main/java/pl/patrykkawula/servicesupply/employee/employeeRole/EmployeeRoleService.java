package pl.patrykkawula.servicesupply.employee.employeeRole;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.employeeRole.dtos.EmployeeRoleDto;
import pl.patrykkawula.servicesupply.exception.EmployeeRoleNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRoleService {
    private final EmployeeRoleRepository employeeRoleRepository;
    private final EmployeeRoleDtoMapper employeeRoleDtoMapper;

    EmployeeRoleService(EmployeeRoleRepository employeeRoleRepository, EmployeeRoleDtoMapper employeeRoleDtoMapper) {
        this.employeeRoleRepository = employeeRoleRepository;
        this.employeeRoleDtoMapper = employeeRoleDtoMapper;
    }

    public List<EmployeeRoleDto> findByName(String name) {
        List<EmployeeRoleDto> employeeRoleList = new ArrayList<>();
        employeeRoleList.add(employeeRoleRepository
                .findByNameIgnoreCase(name)
                .map(employeeRoleDtoMapper::mapToEmployeeRoleNameDto)
                .orElseThrow(() -> new EmployeeRoleNotFoundException(name))
        );
        return employeeRoleList;
    }

    public List<EmployeeRoleDto> getAllEmployeeRoleDto() {
        return employeeRoleRepository.findAll()
                .stream()
                .map(employeeRoleDtoMapper::mapToEmployeeRoleNameDto)
                .toList();
    }

    public List<EmployeeRoleDto> getAllEmployeeRole() {
        return employeeRoleRepository.findAll()
                .stream()
                .map(employeeRoleDtoMapper::mapToEmployeeRoleNameDto)
                .toList();
    }

    public List<EmployeeRoleDto> getRolesByRoleName(String roleName) {
        if (roleName.equalsIgnoreCase("ADMIN")) {
            return getAllEmployeeRole();
        }
        return findByName(roleName);
    }

}
