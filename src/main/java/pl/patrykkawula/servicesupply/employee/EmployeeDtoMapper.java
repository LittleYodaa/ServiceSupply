package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeCredentialsDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRole;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleService;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreService;

import java.util.List;

@Service
class EmployeeDtoMapper {

    private final StoreService storeService;
    private final EmployeeRoleService employeeRoleService;

    EmployeeDtoMapper(StoreService storeService, EmployeeRoleService employeeRoleService) {
        this.storeService = storeService;
        this.employeeRoleService = employeeRoleService;
    }

    EmployeeCredentialsDto mapToEmployeeCredentialsDto(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();
        List<String> roles = employee.getRoles()
                .stream()
                .map(EmployeeRole::getName)
                .toList();
        return new EmployeeCredentialsDto(email, password, roles);
    }

    EmployeeViewDto mapToEmployeeViewDto(Employee employee){
        return EmployeeViewDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .storeId(employee.getStore().getId())
                .build();
    }

    Employee map(EmployeeSaveDto employeeSaveDto) {
        return Employee.builder()
                .firstName(employeeSaveDto.firstName())
                .lastName(employeeSaveDto.lastName())
                .email(employeeSaveDto.email())
                .store(findStoreById(employeeSaveDto.storeId()))
                .roles(getRolesByRoleId(employeeSaveDto.roleId()))
                .build();
    }

    Store findStoreById(Long id) {
        return storeService.findStoreById(id);
    }

    List<EmployeeRole> getRolesByRoleId(Long id) {
        List<EmployeeRole> employeeRoleList;
        if (id == 1) {
            employeeRoleList = employeeRoleService.getAllEmployeeRole();
        } else {
            employeeRoleList = employeeRoleService.findById(id);
        }
        return employeeRoleList;
    }

    //todo
    //chyba mówiłeś kiedyś, że mappery nie powinny zawierać takich metod ale nie wiem jak inaczej można to zrobić...?
}
