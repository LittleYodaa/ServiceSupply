package pl.patrykkawula.servicesupply.employee;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.Cart;
import pl.patrykkawula.servicesupply.Order;
import pl.patrykkawula.servicesupply.Store;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_roles",
    joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<EmployeeRole> roles;
    @ManyToOne
    private Store store;
    @OneToOne(mappedBy = "employee")
    private Cart shoppingCart;
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

}
