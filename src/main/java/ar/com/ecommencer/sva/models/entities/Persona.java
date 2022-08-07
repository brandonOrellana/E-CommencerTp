package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer DNI;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_nacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;
    private String telefono;

    @Embedded
    private Direccion direccion;

    @Embedded
    private Cuenta cuenta;
}
