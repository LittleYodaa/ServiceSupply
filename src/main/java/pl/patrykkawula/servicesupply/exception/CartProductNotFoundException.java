package pl.patrykkawula.servicesupply.exception;

public class CartProductNotFoundException extends ServiceSupplyException{
    public CartProductNotFoundException(Long id) {
        super(String.format("Cart product with id %d not found", id));
    }
}
