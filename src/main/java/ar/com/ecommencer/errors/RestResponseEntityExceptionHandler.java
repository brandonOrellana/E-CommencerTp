package ar.com.ecommencer.errors;

import ar.com.ecommencer.sva.models.entities.ErrorMensage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<ErrorMensage> categoriaNotFoundException(CategoriaNotFoundException exception,
                                                                    WebRequest request){
        ErrorMensage message = new ErrorMensage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(VendedorNotFoundException.class)
    public ResponseEntity<ErrorMensage> vendedorNotFoundException(VendedorNotFoundException exception,
                                                                    WebRequest request){
        ErrorMensage message = new ErrorMensage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorMensage> usuarioNotFoundException(UsuarioNotFoundException exception,
                                                                  WebRequest request){
        ErrorMensage message = new ErrorMensage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorMensage> productoNotFoundException(ProductoNotFoundException exception,
                                                                 WebRequest request){
        ErrorMensage message = new ErrorMensage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErrorMensage> clienteNotFoundException(ClienteNotFoundException exception,
                                                                  WebRequest request){
        ErrorMensage message = new ErrorMensage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}