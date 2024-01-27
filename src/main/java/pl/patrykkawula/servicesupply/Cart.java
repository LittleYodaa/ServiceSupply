package pl.patrykkawula.servicesupply;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.Employee.Employee;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;
}
