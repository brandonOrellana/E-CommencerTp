package ar.com.ecommencer.controller;

import ar.com.ecommencer.dtos.LoginDTO;
import ar.com.ecommencer.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @CrossOrigin
    @PostMapping("/login")
    public LoginDTO validarLogin(@RequestBody LoginDTO login){
        return loginServiceImpl.validarLogin(login);
    }
}
