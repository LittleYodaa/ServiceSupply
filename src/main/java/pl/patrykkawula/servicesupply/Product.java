package pl.patrykkawula.servicesupply;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Brand brand;
    private String name;
    private String link;
    @OneToMany(mappedBy = "product")
    private List<StoreProduct> storeProducts;
    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
