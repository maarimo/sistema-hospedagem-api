package com.hospedagem.sistema.service;

import com.hospedagem.sistema.domain.Room;
import com.hospedagem.sistema.domain.RoomStatus;
import com.hospedagem.sistema.dto.RoomRequestDTO;
import com.hospedagem.sistema.dto.RoomResponseDTO;
import com.hospedagem.sistema.exception.ResourceNotFoundException;
import com.hospedagem.sistema.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    //create
    public RoomResponseDTO create(RoomRequestDTO dto) {

        Room room = new Room();
        room.setNumber(dto.number());
        room.setStatus(RoomStatus.valueOf(dto.status()));

        Room saved = roomRepository.save(room);

        return toResponse(saved);
    }

    //findall
    public List<RoomResponseDTO> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    //findId
    public RoomResponseDTO findById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        return toResponse(room);
    }

    //delete
    public void delete(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Room not found");
        }
        roomRepository.deleteById(id);
    }

    private RoomResponseDTO toResponse(Room room) {
        List<String> guestNames = room.getGuests()
                .stream()
                .map(guest -> guest.getName())
                .toList();

        return new RoomResponseDTO(
                room.getId(),
                room.getNumber(),
                room.getStatus().name(),
                guestNames
        );
    }
}
