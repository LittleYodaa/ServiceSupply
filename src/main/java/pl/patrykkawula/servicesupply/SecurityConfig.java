package pl.patrykkawula.servicesupply;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/").hasAnyRole("ADMIN", "EMPLOYEE")
//                .requestMatchers(h2ConsoleRequestMatcher).permitAll()
                .anyRequest().authenticated()
        );
        http.formLogin();
        http.logout();
        http.csrf().disable();
//        http.csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleRequestMatcher));
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

}
