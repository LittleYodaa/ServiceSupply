package pl.patrykkawula.servicesupply.store;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.employee.Employee;
import pl.patrykkawula.servicesupply.employee.EmployeeRepository;
import pl.patrykkawula.servicesupply.employee.EmployeeService;
import pl.patrykkawula.servicesupply.employee.dtos.EmployeeStoreDto;
import pl.patrykkawula.servicesupply.exception.EmployeeNotFoundException;
import pl.patrykkawula.servicesupply.exception.StoreNotFoundException;
import pl.patrykkawula.servicesupply.store.dtos.StoreDto;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final StoreDtoMapper storeDtoMapper;
    private final EmployeeRepository employeeRepository;

    StoreService(StoreRepository storeRepository, StoreDtoMapper storeDtoMapper, EmployeeRepository employeeRepository) {
        this.storeRepository = storeRepository;
        this.storeDtoMapper = storeDtoMapper;
        this.employeeRepository = employeeRepository;
    }

    public StoreDto findStoreByName(String name) {
        return storeRepository.findByName(name)
                .map(storeDtoMapper::mapToStoreDto)
                .orElseThrow(() -> new StoreNotFoundException(name));
    }

    public List<StoreDto> getAllStores() {
        return storeRepository.findAll()
                .stream()
                .map(storeDtoMapper::mapToStoreDto)
                .toList();
    }

    public StoreDto findStoreById(Long id) {
        return storeRepository.findById(id)
                .map(storeDtoMapper::mapToStoreDto)
                .orElseThrow(() -> new StoreNotFoundException(id));
    }

    public StoreDto getActualEmployeeStore() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails) principal).getUsername();
        Long storeId = employeeRepository.findByEmail(email).map(employee -> employee.getStore().getId()).orElseThrow(() -> new EmployeeNotFoundException(email));
        return employeeRepository.findByEmail(email)
                .map(Employee::getStore)
                .map(storeDtoMapper::mapToStoreDto)
                .orElseThrow(() -> new StoreNotFoundException(storeId));
    }
}
