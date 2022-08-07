package ar.com.ecommencer.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class DolarDTP {
    private String fecha;
    private Double venta;

    public DolarDTP() {
    }


}
