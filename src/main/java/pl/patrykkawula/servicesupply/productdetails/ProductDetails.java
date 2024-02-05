package pl.patrykkawula.servicesupply.productdetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.OrderProduct;
import pl.patrykkawula.servicesupply.StoreProduct;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    private String gama;
    private String safetyData;
    private String code;
    @OneToMany(mappedBy = "productDetails")
    private List<StoreProduct> storeProducts;
    @OneToMany(mappedBy = "productDetails")
    private List<OrderProduct> orderProducts;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public String getBrandName() {
        return brand.getName();
    }
}
