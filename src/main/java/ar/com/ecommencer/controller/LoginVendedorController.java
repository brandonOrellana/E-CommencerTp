package ar.com.ecommencer.controller;

import ar.com.ecommencer.dtos.LoginDTO;
import ar.com.ecommencer.service.LoginVendedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginVendedorController {

    @Autowired
    private LoginVendedorServiceImpl loginVendedorService;

    @CrossOrigin
    @PostMapping("/loginVendedor")
    public LoginDTO validarLogin(@RequestBody LoginDTO login){
        return loginVendedorService.validarLogin(login);
    }
}
