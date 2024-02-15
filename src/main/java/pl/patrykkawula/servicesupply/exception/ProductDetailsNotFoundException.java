package pl.patrykkawula.servicesupply.exception;

public class ProductDetailsNotFoundException extends ServiceSupplyException{
    public ProductDetailsNotFoundException(Long id) {
        super("Product with id %d not found".formatted(id));
    }
}