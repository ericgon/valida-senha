package com.example.validasenha.service;

public interface IPasswordService {
    /**
     * Valida se a senha atende a todos os critérios de domínio.
     * @param password Senha bruta (raw string)
     * @return true se for válida, false caso contrário
     */
    boolean validate(String password);
}