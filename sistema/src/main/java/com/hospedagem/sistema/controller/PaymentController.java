package com.hospedagem.sistema.controller;

import com.hospedagem.sistema.dto.PaymentRequestDTO;
import com.hospedagem.sistema.dto.PaymentResponseDTO;
import com.hospedagem.sistema.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> create(@RequestBody @Valid PaymentRequestDTO dto) {
        PaymentResponseDTO response = paymentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }
}