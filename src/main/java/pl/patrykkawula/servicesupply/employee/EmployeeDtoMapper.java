package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeCredentialsDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeStoreDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRole;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleDtoMapper;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleService;
import pl.patrykkawula.servicesupply.employee.employeeRole.dtos.EmployeeRoleDto;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreService;

import java.util.List;

@Service
class EmployeeDtoMapper {

    // FIXME to musi stąd zniknąć
    // poznikało ale nie wiem czy dobrze to zrobiłem, wszystkie zmiany w metodzie map(EmployeeSaveDto employeeSaveDto, List<EmployeeRole> roles, Store store)

    EmployeeCredentialsDto mapToEmployeeCredentialsDto(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();
        List<String> roles = employee.getRoles()
                .stream()
                .map(EmployeeRole::getName)
                .toList();
        return new EmployeeCredentialsDto(email, password, roles);
    }

    EmployeeViewDto mapToEmployeeViewDto(Employee employee) {
        return EmployeeViewDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .storeId(employee.getStore().getId())
                .build();
    }

    Employee map(EmployeeSaveDto employeeSaveDto, List<EmployeeRole> roles, Store store) {
        return Employee.builder()
                .firstName(employeeSaveDto.firstName())
                .lastName(employeeSaveDto.lastName())
                .email(employeeSaveDto.email())
                .password(employeeSaveDto.password())
                .store(store)
                .roles(roles)
                .build();
    }

    EmployeeStoreDto mapToEmployeeStoreDto(Employee employee) {
        return EmployeeStoreDto.builder()
                .email(employee.getEmail())
                .storeId(employee.getStore().getId())
                .build();
    }
}
