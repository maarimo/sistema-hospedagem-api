package com.hospedagem.sistema.repository;

import com.hospedagem.sistema.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
