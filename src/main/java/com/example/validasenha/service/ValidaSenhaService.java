package com.example.validasenha.service;

import org.springframework.stereotype.Service;

@Service
public class ValidaSenhaService {

    public boolean validar(String senha) {
        return senha != null;
    }

}
