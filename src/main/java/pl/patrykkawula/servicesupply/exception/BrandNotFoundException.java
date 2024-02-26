package pl.patrykkawula.servicesupply.exception;

public class BrandNotFoundException extends ServiceSupplyException{
    public BrandNotFoundException(String name) {
        super(String.format("Brand with name %s not found", name));
    }
}
