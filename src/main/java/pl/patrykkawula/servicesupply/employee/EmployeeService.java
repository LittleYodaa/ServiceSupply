package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeCredentialsDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRole;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleDtoMapper;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleService;
import pl.patrykkawula.servicesupply.store.Store;
import pl.patrykkawula.servicesupply.store.StoreDtoMapper;
import pl.patrykkawula.servicesupply.store.StoreService;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

import java.util.List;
import java.util.Optional;

@Service
class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoMapper employeeDtoMapper;
    private final EmployeeRoleService employeeRoleService;
    private final EmployeeRoleDtoMapper employeeRoleDtoMapper;
    private final StoreService storeService;
    private final StoreDtoMapper storeDtoMapper;
    EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoMapper employeeDtoMapper, EmployeeRoleService employeeRoleService, EmployeeRoleDtoMapper employeeRoleDtoMapper, StoreService storeService, StoreDtoMapper storeDtoMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoMapper = employeeDtoMapper;
        this.employeeRoleService = employeeRoleService;
        this.employeeRoleDtoMapper = employeeRoleDtoMapper;
        this.storeService = storeService;
        this.storeDtoMapper = storeDtoMapper;
    }

    Optional<EmployeeCredentialsDto> findCredentialsByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .map(employeeDtoMapper::mapToEmployeeCredentialsDto);
    }

    List<EmployeeViewDto> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeDtoMapper::mapToEmployeeViewDto)
                .toList();
    }

    void saveEmployee(EmployeeSaveDto employeeSaveDto) {
        List<EmployeeRole> roles = employeeRoleService
                .getRolesByRoleName(employeeSaveDto.roleName())
                .stream()
                .map(employeeRoleDtoMapper::map)
                .toList();
        Store store = storeDtoMapper
                .map(storeService.findStoreByName(employeeSaveDto.storeName()));
        employeeRepository.save(employeeDtoMapper.map(employeeSaveDto, roles, store));
    }

    void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
