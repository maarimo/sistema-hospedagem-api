package com.hospedagem.sistema.dto;

public record GuestResponseDTO(
        Long id,
        String name,
        String cpf,
        String phone,
        String status,
        Integer roomNumber
) {}