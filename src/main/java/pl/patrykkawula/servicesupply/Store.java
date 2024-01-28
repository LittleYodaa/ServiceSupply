package pl.patrykkawula.servicesupply;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.patrykkawula.servicesupply.employee.Employee;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "store")
    private List<Employee> employees;
    @OneToMany(mappedBy = "store")
    private List<StoreProduct> storeProducts;
    @OneToMany
    @JoinColumn(name = "store_id")
    private List<Order> orders;

}