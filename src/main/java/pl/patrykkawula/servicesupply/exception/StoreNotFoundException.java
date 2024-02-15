package pl.patrykkawula.servicesupply.exception;

public class StoreNotFoundException extends ServiceSupplyException {
    public StoreNotFoundException(Long id) {
        super("Store with id %d not found".formatted(id));
    }

    public StoreNotFoundException(String name) {
        super("Store with name %s not found".formatted(name));
    }
}
