package com.hospedagem.sistema.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotNull BigDecimal amount,
        @NotNull String status,
        @NotNull Long guestId
) {}