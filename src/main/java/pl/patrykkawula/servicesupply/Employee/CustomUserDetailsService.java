package pl.patrykkawula.servicesupply.Employee;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.Employee.dtos.EmployeeCredentialsDto;

@Service
class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeService employeeService;

    CustomUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeService.findCredentialsByEmail((username))
                .map(this::createUserDetails)
                .orElseThrow(() ->new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    private UserDetails createUserDetails(EmployeeCredentialsDto credentials) {
        return User.builder()
                .username(credentials.email())
                .password(credentials.password())
                .roles(credentials.roles().toArray(String[]::new))
                .build();
    }
}
