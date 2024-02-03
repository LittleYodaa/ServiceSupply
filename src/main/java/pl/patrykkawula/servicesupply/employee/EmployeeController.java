package pl.patrykkawula.servicesupply.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;

import java.util.List;

@Controller
@RequestMapping("/employees")
class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    String findAllEmployees(Model model) {
        List<EmployeeViewDto> employeeList = employeeService.findAllEmplyees();
        model.addAttribute("employeeList", employeeList);
        return "/employee/employees";
    }

    @PostMapping("/addEmployee")
    String saveEmplyee(@ModelAttribute ("employeeSaveDto") EmployeeSaveDto employeeSaveDto) {
        employeeService.saveEmployee(employeeSaveDto);
        return "redirect/employees";
    }
}
