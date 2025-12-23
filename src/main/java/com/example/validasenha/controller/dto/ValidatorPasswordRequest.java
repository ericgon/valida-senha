package com.example.validasenha.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record ValidatorPasswordRequest(
    @NotBlank(message = "Senha não pode ser nulla ou vazia")
    String password) {
}
