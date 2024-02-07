package pl.patrykkawula.servicesupply.employee;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeSaveDto;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeViewDto;
import pl.patrykkawula.servicesupply.employee.employeeRole.EmployeeRoleService;
import pl.patrykkawula.servicesupply.employee.employeeRole.dtos.EmployeeRoleDto;
import pl.patrykkawula.servicesupply.store.StoreService;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

import java.util.List;

@Controller
@RequestMapping("/employees")
class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRoleService employeeRoleService;
    private final StoreService storeService;

    EmployeeController(EmployeeService employeeService, EmployeeRoleService employeeRoleService, StoreService storeService) {
        this.employeeService = employeeService;
        this.employeeRoleService = employeeRoleService;
        this.storeService = storeService;
    }

    @GetMapping("")
    String findAllEmployees(Model model) {
        List<EmployeeViewDto> employeeList = employeeService.findAllEmployees();
        model.addAttribute("employeeList", employeeList);
        return "/employee/employees";
    }

    @GetMapping("/showNewEmployeeForm")
    String showNewEmployeeForm(Model model) {
        List<EmployeeRoleDto> allEmployeeRoleDto = employeeRoleService.getAllEmployeeRoleDto();
        EmployeeSaveDto employeeSaveDto = EmployeeSaveDto.builder().build();
        List<StoreDto> allStores = storeService.getAllStores();
        model.addAttribute("employeeRoles", allEmployeeRoleDto);
        model.addAttribute("employeeSaveDto", employeeSaveDto);
        model.addAttribute("stores", allStores);
        return "/employee/new_employee";
    }

    @PostMapping("/addEmployee")
    String saveEmplyee(@Valid @ModelAttribute("employeeSaveDto") EmployeeSaveDto employeeSaveDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<StoreDto> allStores = storeService.getAllStores();
            List<EmployeeRoleDto> allEmployeeRoleDto = employeeRoleService.getAllEmployeeRoleDto();
            model.addAttribute("stores", allStores);
            model.addAttribute("employeeRoles", allEmployeeRoleDto);
            return "/employee/new_employee";
        } else {
            employeeService.saveEmployee(employeeSaveDto);
            return "redirect:/employees";
        }
    }

    @GetMapping("/deleteEmployee/{id}")
    String deleteEmployeeById(@PathVariable (value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
