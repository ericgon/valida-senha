package com.example.validasenha;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ValidatorPasswordIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldValidateCorrectPassword() throws Exception {
        String jsonBody = """
                { "password": "AbTp9!fok" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void shouldRejectInvalidPassword_empty() throws Exception {
        String jsonBody = """
                { "password": "" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Senha não pode ser nulla ou vazia"));
    }

    @Test
    void shouldRejectInvalidPassword_null() throws Exception {
        String jsonBody = """
                { "password": null }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Senha não pode ser nulla ou vazia"));
    }

    @Test
    void shouldRejectInvalidPassword_RepeatedChar() throws Exception {
        String jsonBody = """
                { "password": "AbTp9!foo" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldRejectInvalidPassword_NoSpace() throws Exception {
        String jsonBody = """
                { "password": "Ab Tp9!fok" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldRejectInvalidPassword_Length() throws Exception {
        String jsonBody = """
                { "password": "Ap9!f" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldRejectInvalidPassword_CharType() throws Exception {
        String jsonBody = """
                { "password": "abtp9!fok" }
                """;

        mockMvc.perform(post("/v1/passwords/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}