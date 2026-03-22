package com.hospedagem.sistema.service;

import com.hospedagem.sistema.domain.Guest;
import com.hospedagem.sistema.domain.GuestStatus;
import com.hospedagem.sistema.domain.Room;
import com.hospedagem.sistema.repository.GuestRepository;
import com.hospedagem.sistema.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    //criar hospede
    public Guest create(Guest guest, Long roomId) {

        // 1. validar CPF único
        if (guestRepository.findByCpf(guest.getCpf()).isPresent()) {
            throw new RuntimeException("CPF already exists");
        }

        // 2. buscar quarto
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // 3. associar quarto
        guest.setRoom(room);

        // 4. status inicial
        guest.setStatus(GuestStatus.PENDING);

        // 5. salvar
        return guestRepository.save(guest);
    }

    //buscar todos
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    //buscar por id
    public Guest findById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    //delete
    public void delete(Long id) {
        if (!guestRepository.existsById(id)) {
            throw new RuntimeException("Guest not found");
        }
        guestRepository.deleteById(id);
    }

}
