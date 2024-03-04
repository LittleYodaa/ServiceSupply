package pl.patrykkawula.servicesupply.exception;

public class EmployeeNotFoundException extends ServiceSupplyException{
    public EmployeeNotFoundException(Long id) {
        super(String.format("Employee with id %d not found", id));
    }

    public EmployeeNotFoundException(String name) {
        super(String.format("Employee with name %s not found", name));
    }
}
