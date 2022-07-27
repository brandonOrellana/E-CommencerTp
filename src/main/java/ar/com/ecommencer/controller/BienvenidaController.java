package ar.com.ecommencer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaController {
    @Value("${welcome.message}")
    private String bienvenida;

    @GetMapping("/")
    public String mensageBienvenida(){
        return bienvenida;
    }
}
