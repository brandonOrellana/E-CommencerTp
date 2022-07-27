package ar.com.ecommencer.controller;


import ar.com.ecommencer.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;



}
