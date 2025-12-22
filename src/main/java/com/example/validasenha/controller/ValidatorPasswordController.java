package com.example.validasenha.controller;

import com.example.validasenha.controller.dto.ValidatorPasswordRequest;
import com.example.validasenha.service.ValidatorPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/senha")
public class ValidatorPasswordController {

    private final ValidatorPasswordService validatorPasswordService;

    public ValidatorPasswordController(ValidatorPasswordService validatorPasswordService) {
        this.validatorPasswordService = validatorPasswordService;
    }

    @PostMapping("/validar")
    public ResponseEntity<Boolean> validatePassword(@RequestBody ValidatorPasswordRequest request) {
        boolean isValid = validatorPasswordService.validate(request.password());
        return ResponseEntity.ok(isValid);
    }

}
