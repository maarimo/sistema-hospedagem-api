package com.hospedagem.sistema.repository;

import com.hospedagem.sistema.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Object> findByCpf(String cpf);
}
