package pl.patrykkawula.servicesupply;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne
    private Store store;
    @OneToOne
    @JoinColumn(name = "shopping_cart_id", unique = true)
    private ShoppingCart shoppingCart;
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

}
