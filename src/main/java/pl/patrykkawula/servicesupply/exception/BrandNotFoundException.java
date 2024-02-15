package pl.patrykkawula.servicesupply.exception;

public class BrandNotFoundException extends ServiceSupplyException{
    public BrandNotFoundException(String name) {
        super("Brand with name %s not found".formatted(name));
    }
}
