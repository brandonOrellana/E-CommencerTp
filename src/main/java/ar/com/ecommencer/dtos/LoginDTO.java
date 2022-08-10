package ar.com.ecommencer.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDTO {
    private String email;
    private String contrasenia;
    private Boolean estado;
    private String mensage;
    private Long id;
}
