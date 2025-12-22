package com.example.validasenha.service;

import com.example.validasenha.domain.rules.ValidatePasswordRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidatorPasswordService {

    private final List<ValidatePasswordRule> validationRules;

    public ValidatorPasswordService(List<ValidatePasswordRule> validationRules){
        this.validationRules = validationRules;
    }

    public boolean validate(String password) {
        if (password == null) return false;
        return validationRules.stream()
                .allMatch(validatePasswordRule -> validatePasswordRule.isValid(password));
    }

}
