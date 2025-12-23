package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

@Component
public class NoSpaceRule implements IValidatePasswordRule {
    @Override
    public boolean isValid(String password) {
        if (password == null) return false;
        // valida se a senha contem espaço em branco
        return !password.contains(" ");
    }
}
