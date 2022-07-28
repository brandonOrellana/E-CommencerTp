package ar.com.ecommencer.errors;

public class CategoriaNotFoundException extends Exception{
    public CategoriaNotFoundException() {
        super();
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }

    public CategoriaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoriaNotFoundException(Throwable cause) {
        super(cause);
    }

    public CategoriaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
