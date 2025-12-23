package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

@Component
public class LengthRule implements IValidatePasswordRule {
    private static final int MIN_LENGTH = 9;

    @Override
    public boolean isValid(String password){
        // retorna true se a senha tiver 9 ou mais caracteres
        return password != null && password.length() >= MIN_LENGTH;
    }
}
