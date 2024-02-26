package pl.patrykkawula.servicesupply.storeproduct;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.store.Store;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToOne
    @JoinColumn(name = "product_details_id", referencedColumnName = "id")
    private ProductDetails productDetails;
    private Long productQuantity;
}
