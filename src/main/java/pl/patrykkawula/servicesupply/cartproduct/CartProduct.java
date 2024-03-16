package pl.patrykkawula.servicesupply.cartproduct;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.employee.Employee;
import pl.patrykkawula.servicesupply.order.Order;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.store.Store;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productQuantity;

    @ManyToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;


}
