package com.example.validasenha.service;

import com.example.validasenha.domain.rules.IValidatePasswordRule;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PasswordTest {

    @Test
    void shouldReturnTrueWhenAllRulesAreSatisfied() {
        IValidatePasswordRule rule1 = mock(IValidatePasswordRule.class);
        IValidatePasswordRule rule2 = mock(IValidatePasswordRule.class);

        when(rule1.isValid(anyString())).thenReturn(true);
        when(rule2.isValid(anyString())).thenReturn(true);

        PasswordService service = new PasswordService(List.of(rule1, rule2));

        String password = "anyPassword";
        boolean result = service.validate(password);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenAtLeastOneRuleFails() {
        IValidatePasswordRule rule1 = mock(IValidatePasswordRule.class);
        IValidatePasswordRule rule2 = mock(IValidatePasswordRule.class);

        when(rule1.isValid(anyString())).thenReturn(true);
        when(rule2.isValid(anyString())).thenReturn(false);

        PasswordService service = new PasswordService(List.of(rule1, rule2));

        String password = "anyPassword";
        boolean result = service.validate(password);

        assertFalse(result);
    }
}