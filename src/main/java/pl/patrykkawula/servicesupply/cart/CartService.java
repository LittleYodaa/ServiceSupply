//package pl.patrykkawula.servicesupply.cart;
//
//import org.springframework.stereotype.Service;
//import pl.patrykkawula.servicesupply.employee.Employee;
//import pl.patrykkawula.servicesupply.employee.EmployeeDtoMapper;
//import pl.patrykkawula.servicesupply.employee.EmployeeRepository;
//import pl.patrykkawula.servicesupply.employee.EmployeeService;
//import pl.patrykkawula.servicesupply.exception.EmployeeNotFoundException;
//
//import java.util.ArrayList;
//
//@Service
//class CartService {
//    private final CartRepository cartRepository;
//    private final EmployeeService employeeService;
//    private final EmployeeDtoMapper employeeDtoMapper;
//    private final EmployeeRepository employeeRepository;
//
//    CartService(CartRepository cartRepository, EmployeeService employeeService, EmployeeDtoMapper employeeDtoMapper, EmployeeRepository employeeRepository) {
//        this.cartRepository = cartRepository;
//        this.employeeService = employeeService;
//        this.employeeDtoMapper = employeeDtoMapper;
//        this.employeeRepository = employeeRepository;
//    }
//
//    Cart cartInitialization() {
//        Long employeeCartId = employeeService.getActualEmployeeStoreDto().id();
//        Employee employee = employeeRepository.findById(employeeCartId).orElseThrow(() -> new EmployeeNotFoundException(employeeCartId));
//        return new Cart(employeeCartId, employee, new ArrayList<>());
//    }
//}
