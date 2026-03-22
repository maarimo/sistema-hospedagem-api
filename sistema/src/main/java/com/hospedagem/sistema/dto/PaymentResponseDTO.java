package com.hospedagem.sistema.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResponseDTO(
        Long id,
        BigDecimal amount,
        LocalDate paymentDate,
        String status,
        String guestName
) {}