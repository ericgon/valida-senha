package com.example.validasenha.domain.rules;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class CharacterTypeRule implements ValidatePasswordRule {

    // Regex para: !@#$%^&*()-+
    private static final Pattern SPECIAL_CHAR = Pattern.compile(".*[!@#$%^&*()\\-+].*");
    private static final Pattern DIGIT = Pattern.compile(".*\\d.*");
    private static final Pattern UPPERCASE = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE = Pattern.compile(".*[a-z].*");

    @Override
    public boolean isValid(String password) {
        if (password == null) return false;

        return DIGIT.matcher(password).matches() &&
                UPPERCASE.matcher(password).matches() &&
                LOWERCASE.matcher(password).matches() &&
                SPECIAL_CHAR.matcher(password).matches();
    }

}
