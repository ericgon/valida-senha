package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

@Component
public class NoSpaceRule implements ValidatePasswordRule {
    @Override
    public boolean isValid(String password) {
        if (password == null) return false;
        return !password.contains(" ");
    }
}
