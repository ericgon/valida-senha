package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

@Component
public class NoRepeatedCharactersRule implements IValidatePasswordRule {
    @Override
    public boolean isValid(String password) {
        if (password == null) return false;
        // valida se a senha não possui caracter repedito
        long distinctCount = password.chars().distinct().count();
        return distinctCount == password.length();
    }
}
