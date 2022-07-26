package ar.com.ecommencer.controller;

import ar.com.ecommencer.repository.ProductoRepository;
import ar.com.ecommencer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    private ProductoService a;

    @GetMapping("/")
    public String hello(){
        return welcomeMessage;
    }
}
