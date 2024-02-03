package pl.patrykkawula.servicesupply.employee.employeeRole;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRoleService {
    private final EmployeeRoleRepository employeeRoleRepository;

    EmployeeRoleService(EmployeeRoleRepository employeeRoleRepository) {
        this.employeeRoleRepository = employeeRoleRepository;
    }

    public List<EmployeeRole> findById(Long id) {
        List<EmployeeRole> employeeRoleList = new ArrayList<>();
        employeeRoleList.add(employeeRoleRepository.findById(id).orElseThrow());
        return employeeRoleList;
    }

    public List<EmployeeRole> getAllEmployeeRole() {
        return employeeRoleRepository.findAll();
    }
}
