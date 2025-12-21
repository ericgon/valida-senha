package com.example.validasenha.controller;

import com.example.validasenha.controller.dto.ValidaSenhaRequest;
import com.example.validasenha.service.ValidaSenhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/senha")
public class ValidaSenhaController {

    private final ValidaSenhaService validaSenhaService;

    public ValidaSenhaController(ValidaSenhaService validaSenhaService) {
        this.validaSenhaService = validaSenhaService;
    }

    @PostMapping("/validar")
    public ResponseEntity<Boolean> validarSenha(@RequestBody ValidaSenhaRequest request) {
        boolean isValid = validaSenhaService.validar(request.senha());
        return ResponseEntity.ok(isValid);
    }

}
