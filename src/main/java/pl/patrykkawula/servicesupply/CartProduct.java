package pl.patrykkawula.servicesupply;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productQuantity;
    @OneToOne
    @JoinColumn(name = "product_details_id", unique = true)
    private ProductDetails productDetails;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
