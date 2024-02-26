package pl.patrykkawula.servicesupply.productdetails;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.orderproduct.OrderProduct;

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
//    @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL)
//    private StoreProduct storeProduct;
    @OneToMany(mappedBy = "productDetails")
    private List<OrderProduct> orderProducts;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public String getBrandName() {
        return brand.getName();
    }
}
