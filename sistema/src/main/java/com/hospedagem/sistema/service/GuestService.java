package com.hospedagem.sistema.service;

import com.hospedagem.sistema.domain.Guest;
import com.hospedagem.sistema.domain.GuestStatus;
import com.hospedagem.sistema.domain.Room;
import com.hospedagem.sistema.dto.GuestRequestDTO;
import com.hospedagem.sistema.dto.GuestResponseDTO;
import com.hospedagem.sistema.exception.BusinessException;
import com.hospedagem.sistema.exception.ResourceNotFoundException;
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

    public GuestResponseDTO create(GuestRequestDTO dto) {

        // 1. validar CPF único
        if (guestRepository.findByCpf(dto.cpf()).isPresent()) {
            throw new BusinessException("CPF already exists");
        }

        // 2. buscar quarto
        Room room = roomRepository.findById(dto.roomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        // 3. converter DTO → Entity
        Guest guest = new Guest();
        guest.setName(dto.name());
        guest.setCpf(dto.cpf());
        guest.setPhone(dto.phone());
        guest.setStatus(GuestStatus.PENDING);
        guest.setRoom(room);

        // 4. salvar
        Guest saved = guestRepository.save(guest);

        // 5. converter Entity → DTO
        return toResponse(saved);
    }

    public List<GuestResponseDTO> findAll() {
        return guestRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public GuestResponseDTO findById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        return toResponse(guest);
    }

    public void delete(Long id) {
        if (!guestRepository.existsById(id)) {
            throw new ResourceNotFoundException("Guest not found");
        }
        guestRepository.deleteById(id);
    }

    // 🔥 mapper manual (simples e profissional)
    private GuestResponseDTO toResponse(Guest guest) {
        return new GuestResponseDTO(
                guest.getId(),
                guest.getName(),
                guest.getCpf(),
                guest.getPhone(),
                guest.getStatus().name(),
                guest.getRoom() != null ? guest.getRoom().getNumber() : null
        );
    }
}