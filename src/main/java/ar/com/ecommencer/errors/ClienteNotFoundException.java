package ar.com.ecommencer.errors;

public class ClienteNotFoundException extends Exception{
    public ClienteNotFoundException() {
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteNotFoundException(Throwable cause) {
        super(cause);
    }

    public ClienteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
