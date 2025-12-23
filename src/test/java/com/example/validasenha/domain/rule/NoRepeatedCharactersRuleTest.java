package com.example.validasenha.domain.rule;

import com.example.validasenha.domain.rules.NoRepeatedCharactersRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoRepeatedCharactersRuleTest {
    private final NoRepeatedCharactersRule rule = new NoRepeatedCharactersRule();

    @Test
    void shouldReturnFalseWhenCharactersAreRepeated() {
        assertFalse(rule.isValid("abcda")); // 'a' repetido
    }

    @Test
    void shouldReturnTrueWhenAllCharactersAreUnique() {
        assertTrue(rule.isValid("abcdef"));
    }
}