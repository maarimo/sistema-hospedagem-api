package com.hospedagem.sistema.dto;

import jakarta.validation.constraints.NotNull;

public record RoomRequestDTO(
        @NotNull Integer number,
        @NotNull String status
) {}