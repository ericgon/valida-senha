package com.example.validasenha.controller.exception;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Faz essa classe observar todos os Controllers
public class GlobalExceptionHandler {

    private final MeterRegistry registry;

    //metricas de erros
    public GlobalExceptionHandler(MeterRegistry registry) {
        this.registry = registry;
    }

    // Trata erros de validação (ex: @NotBlank do DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 400);

        // Pega a mensagem de erro que definimos no DTO
        String errorMessage = ex.getBindingResult().getFieldErrors().getFirst().getDefaultMessage();
        body.put("error", errorMessage);

        return ResponseEntity.badRequest().body(body);
    }

    // Trata qualquer outro erro inesperado (Erro 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 500);
        body.put("error", "An internal server error occurred");

        return ResponseEntity.internalServerError().body(body);
    }
}