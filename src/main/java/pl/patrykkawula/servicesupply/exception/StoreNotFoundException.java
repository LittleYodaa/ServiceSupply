package pl.patrykkawula.servicesupply.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(Long id) {
        super("Store with id %d not found".formatted(id));
    }
}
