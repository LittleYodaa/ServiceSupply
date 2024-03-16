package pl.patrykkawula.servicesupply.store;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import pl.patrykkawula.servicesupply.cartproduct.CartProduct;
import pl.patrykkawula.servicesupply.order.Order;
import pl.patrykkawula.servicesupply.storeproduct.StoreProduct;
import pl.patrykkawula.servicesupply.employee.Employee;

import java.util.List;

@Entity
@Builder
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
    @OneToMany(mappedBy = "store")
    private List<CartProduct> cartProducts;
    @OneToMany
    @JoinColumn(name = "store_id")
    private List<Order> orders;

}