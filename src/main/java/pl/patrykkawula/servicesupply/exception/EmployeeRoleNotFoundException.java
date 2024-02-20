package pl.patrykkawula.servicesupply.exception;

public class EmployeeRoleNotFoundException extends ServiceSupplyException{
    public EmployeeRoleNotFoundException(String name) {
        super("Employee role with name %s not found".formatted(name));
    }
}
