package pl.patrykkawula.servicesupply.orderproduct;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.order.Order;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;
    private Long productQuantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
