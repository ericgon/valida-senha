package com.example.validasenha.service;

import com.example.validasenha.domain.Password;
import com.example.validasenha.domain.rules.IValidatePasswordRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService implements IPasswordService{

    private final List<IValidatePasswordRule> validationRules;

    public PasswordService(List<IValidatePasswordRule> validationRules){
        this.validationRules = validationRules;
    }

    @Override
    public boolean validate(String rawpassword) {

        Password password = new Password(rawpassword);
        return password.isValid(this.validationRules);

    }

}
