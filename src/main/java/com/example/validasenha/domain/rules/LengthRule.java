package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

@Component
public class LengthRule implements ValidatePasswordRule {
    private static final int MIN_LENGTH = 9;

    @Override
    public boolean isValid(String password){
        return password != null && password.length() >= MIN_LENGTH;
    }
}
