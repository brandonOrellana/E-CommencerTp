package ar.com.ecommencer.sva.models.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendedor_id")
    private Long vendedorId;

    @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "VARCHAR(255)")
    private String apellido;

    @Column(name = "telefono", columnDefinition = "VARCHAR(255)")
    private String telefono;

    @Column(name = "fecha_nacimiento", columnDefinition = "DATE")
    private LocalDate fechaNacimiento;
}