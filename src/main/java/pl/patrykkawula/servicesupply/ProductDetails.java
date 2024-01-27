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
class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    @OneToMany(mappedBy = "productDetails")
    private List<StoreProduct> storeProducts;
    @OneToMany(mappedBy = "productDetails")
    private List<OrderProduct> orderProducts;
}
