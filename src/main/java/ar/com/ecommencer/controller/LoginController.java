package ar.com.ecommencer.controller;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.LoginDTO;
import ar.com.ecommencer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @PostMapping("/login")
    public LoginDTO validarLogin(@RequestBody LoginDTO login){
        return loginService.validarLogin(login);
    }
}
