package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CharacterTypeRule implements IValidatePasswordRule {

    // Regex para: !@#$%^&*()-+
    private static final Pattern SPECIAL_CHAR = Pattern.compile(".*[!@#$%^&*()\\-+].*");
    // Regex para digito 0-9
    private static final Pattern DIGIT = Pattern.compile(".*\\d.*");
    // Regex letra Maiuscula
    private static final Pattern UPPERCASE = Pattern.compile(".*[A-Z].*");
    // Regex letra minuscula
    private static final Pattern LOWERCASE = Pattern.compile(".*[a-z].*");

    @Override
    public boolean isValid(String password) {
        if (password == null) return false;

        // retorna true se todas as condições do regex forem satisfeita
        return DIGIT.matcher(password).matches() &&
                UPPERCASE.matcher(password).matches() &&
                LOWERCASE.matcher(password).matches() &&
                SPECIAL_CHAR.matcher(password).matches();
    }

}
