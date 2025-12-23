package com.example.validasenha.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ValidatorPasswordRequest(
    @NotBlank(message = "Senha não pode ser vazia")
    @NotNull(message = "Senha não pode ser nulla")
    String password) {
}
