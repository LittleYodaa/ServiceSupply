package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
