package pl.patrykkawula.servicesupply.cartproduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}
