package pl.patrykkawula.servicesupply.cartproduct;

import jakarta.persistence.*;
import lombok.*;
import pl.patrykkawula.servicesupply.cart.Cart;
import pl.patrykkawula.servicesupply.employee.Employee;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;

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

    //todo
    //chyba zła relacja do productDetails, jeden productDetails może mieć wiele cartProduct
    //poprawione na ManyToOne wydaje się być okej
    @ManyToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;

    //todo
    //chyba trzeba to usunąć i zrobić relacje jednostronną z właścicielem relacji cart, do doczytania
    //wprowadzić nowy branch z obecnego brancha
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
