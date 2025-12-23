package com.example.validasenha.domain;

import com.example.validasenha.domain.rules.IValidatePasswordRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PasswordTest {

    @Test
    @DisplayName("Should return true when all provided rules are satisfied")
    void shouldReturnTrueWhenAllRulesAreSatisfied() {
        // Arrange (Prepara os mocks)
        IValidatePasswordRule rule1 = mock(IValidatePasswordRule.class);
        IValidatePasswordRule rule2 = mock(IValidatePasswordRule.class);

        when(rule1.isValid(anyString())).thenReturn(true);
        when(rule2.isValid(anyString())).thenReturn(true);

        Password password = new Password("valid_string");
        List<IValidatePasswordRule> rules = List.of(rule1, rule2);

        // Act (Executa a ação do domínio)
        boolean result = password.isValid(rules);

        // Assert (Verifica o resultado)
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when at least one rule fails")
    void shouldReturnFalseWhenOneRuleFails() {
        // Arrange
        IValidatePasswordRule rulePass = mock(IValidatePasswordRule.class);
        IValidatePasswordRule ruleFail = mock(IValidatePasswordRule.class);

        when(rulePass.isValid(anyString())).thenReturn(true);
        when(ruleFail.isValid(anyString())).thenReturn(false);

        Password password = new Password("any_string");

        // Act
        boolean result = password.isValid(List.of(rulePass, ruleFail));

        // Assert
        assertFalse(result);
    }
}