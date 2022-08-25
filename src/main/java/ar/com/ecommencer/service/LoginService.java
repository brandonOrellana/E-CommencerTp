package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.LoginDTO;

public interface LoginService {
    LoginDTO validarLogin(LoginDTO login);
}
