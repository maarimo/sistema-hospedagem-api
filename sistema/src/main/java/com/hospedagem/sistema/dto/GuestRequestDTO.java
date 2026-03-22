package com.hospedagem.sistema.dto;

import jakarta.validation.constraints.NotBlank;

public record GuestRequestDTO(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank String phone,
        Long roomId
) {}
