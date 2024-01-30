package pl.patrykkawula.servicesupply.brand;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "brand")
    List<ProductDetails> products;
}
