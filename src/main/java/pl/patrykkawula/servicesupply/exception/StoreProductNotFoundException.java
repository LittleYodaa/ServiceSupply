package pl.patrykkawula.servicesupply.exception;

public class StoreProductNotFoundException extends ServiceSupplyException {
    public StoreProductNotFoundException(String name) {
        super("Store product with name %s not found".formatted(name));
    }
}
