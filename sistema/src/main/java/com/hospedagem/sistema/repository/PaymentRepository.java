package com.hospedagem.sistema.repository;

import com.hospedagem.sistema.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
