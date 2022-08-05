package ar.com.ecommencer.sva.models.entities;

import java.time.LocalDate;

public class Compra {
    private Usuario usuario;
    private Carrito carrito;
    private LocalDate fechaCompra;
    private String medioDePago;
    private Double totalAPagar;
}
