package com.example.validasenha.controller;

import com.example.validasenha.controller.dto.ValidatorPasswordRequest;
import com.example.validasenha.service.IPasswordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/passwords")
public class PasswordController {

    private final IPasswordService passwordService;

    public PasswordController(IPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validatePassword(@Valid @RequestBody ValidatorPasswordRequest request) {
        boolean isValid = passwordService.validate(request.password());
        return ResponseEntity.ok(isValid);
    }

}
