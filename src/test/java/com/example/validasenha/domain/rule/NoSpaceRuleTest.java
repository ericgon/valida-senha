package com.example.validasenha.domain.rule;

import com.example.validasenha.domain.rules.NoSpaceRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoSpaceRuleTest {
    private final NoSpaceRule rule = new NoSpaceRule();

    @Test
    void shouldReturnFalseWhenCharacterSpace() {
        assertFalse(rule.isValid("abc da")); // 'a' repetido
    }

    @Test
    void shouldReturnTrueWhenAllCharactersNoSpace() {
        assertTrue(rule.isValid("abcdef"));
    }
}

