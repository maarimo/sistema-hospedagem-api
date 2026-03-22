package com.hospedagem.sistema.controller;

import com.hospedagem.sistema.dto.GuestRequestDTO;
import com.hospedagem.sistema.dto.GuestResponseDTO;
import com.hospedagem.sistema.service.GuestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    //criar hospede
    @PostMapping
    public ResponseEntity<GuestResponseDTO> create(@RequestBody @Valid GuestRequestDTO dto) {
        GuestResponseDTO response = guestService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<GuestResponseDTO>> findAll() {
        return ResponseEntity.ok(guestService.findAll());
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<GuestResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.findById(id));
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guestService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
