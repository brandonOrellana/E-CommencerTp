package ar.com.ecommencer.errors;

public class VendedorNotFoundException extends Exception{
    public VendedorNotFoundException() {
    }

    public VendedorNotFoundException(String message) {
        super(message);
    }

    public VendedorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendedorNotFoundException(Throwable cause) {
        super(cause);
    }

    public VendedorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
