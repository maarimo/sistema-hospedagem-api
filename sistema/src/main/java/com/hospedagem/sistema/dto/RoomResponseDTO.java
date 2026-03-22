package com.hospedagem.sistema.dto;

import java.util.List;

public record RoomResponseDTO(
        Long id,
        Integer number,
        String status,
        List<String> guests
) {}