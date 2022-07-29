package ar.com.ecommencer.errors;

public class ProductoNotFoundException extends Exception{
    public ProductoNotFoundException() {
    }

    public ProductoNotFoundException(String message) {
        super(message);
    }

    public ProductoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
