package pl.patrykkawula.servicesupply.employee.employeeRole;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.employeeRole.dtos.EmployeeRoleDto;

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

    public List<EmployeeRole> findByName(String name) {
        List<EmployeeRole> employeeRoleList = new ArrayList<>();
        employeeRoleList.add(employeeRoleRepository.findByNameIgnoreCase(name)
                .orElseThrow());
        return employeeRoleList;
    }

    //todo
    //wyjątek do stworzenia

    public List<EmployeeRoleDto> getAllEmployeeRoleDto() {
        return employeeRoleRepository.findAll()
                .stream()
                .map(employeeRoleDtoMapper::mapToEmployeeRoleNameDto)
                .toList();
    }

    public List<EmployeeRole> getAllEmployeeRole() {
        return employeeRoleRepository.findAll();
    }

    //todo
    //tu tak samo jak w store, metoda getAllEmployeeRoleDto wystawia listę ról na widok z kolei ta druga zwraca już encję do
    //mappera klasy Employye, pogubiłem się trochę z tymi dtosami przy widoku....


}
