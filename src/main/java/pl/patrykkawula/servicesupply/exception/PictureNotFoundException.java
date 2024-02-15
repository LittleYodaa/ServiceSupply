package pl.patrykkawula.servicesupply.exception;

public class PictureNotFoundException extends ServiceSupplyException{
    public PictureNotFoundException(String name) {
        super(String.format("Picture with name: %s not found", name));
    }
}
