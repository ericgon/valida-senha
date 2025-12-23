package com.example.validasenha.domain;

import com.example.validasenha.domain.rules.IValidatePasswordRule;

import java.util.List;

public record Password(String value) {

    public boolean isValid(List<IValidatePasswordRule> rules) {
        if (value == null) return false;

        // A própria senha se valida contra uma lista de regras
        return rules.stream().allMatch(rule -> rule.isValid(this.value));
    }
}
