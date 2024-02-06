package pl.patrykkawula.servicesupply.employee.employeeRole;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
    Optional<EmployeeRole> findByNameIgnoreCase(String name);
}
