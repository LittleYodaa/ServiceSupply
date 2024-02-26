package pl.patrykkawula.servicesupply.storeproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkawula.servicesupply.productdetails.ProductDetails;
import pl.patrykkawula.servicesupply.store.Store;

import java.util.Optional;

public interface StoreProductRepository extends JpaRepository<StoreProduct, Long> {
    Optional<StoreProduct> findByProductDetailsAndStore(ProductDetails productDetails, Store store);
}
