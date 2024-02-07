package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeCredentialsDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRole;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleDtoMapper;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleService;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreService;

import java.util.List;

@Service
class EmployeeDtoMapper {

    private final StoreService storeService;
    private final EmployeeRoleService employeeRoleService;
    private final EmployeeRoleDtoMapper employeeRoleDtoMapper;

    EmployeeDtoMapper(StoreService storeService, EmployeeRoleService employeeRoleService, EmployeeRoleDtoMapper employeeRoleDtoMapper) {
        this.storeService = storeService;
        this.employeeRoleService = employeeRoleService;
        this.employeeRoleDtoMapper = employeeRoleDtoMapper;
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
                .id(employee.getId())
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
                .password(employeeSaveDto.password())
                .store(findStoreByName(employeeSaveDto.storeName()))
                .roles(getRolesByRoleName(employeeSaveDto.roleName()))
                .build();
    }

    Store findStoreByName(String name) {
        return storeService.findStoreByName(name);
    }

    List<EmployeeRole> getRolesByRoleName(String roleName) {
        List<EmployeeRole> employeeRoleList;
        if (roleName.equalsIgnoreCase("ADMIN")) {
            employeeRoleList = employeeRoleService.getAllEmployeeRole();
        } else {
            employeeRoleList = employeeRoleService.findByName("EMPLOYEE");
        }
        return employeeRoleList;
    }


    //todo
    //chyba mówiłeś kiedyś, że mappery nie powinny zawierać takich metod ale nie wiem jak inaczej można to zrobić...?
    //dużo tego jest też dlatego, że z tych prostych obiektówm które mają tylko np id i name też robie dtosy, które zawierają to samo ale tak chyba powinno się robić?
}
