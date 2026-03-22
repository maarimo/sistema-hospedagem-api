package com.hospedagem.sistema.service;

import com.hospedagem.sistema.domain.Guest;
import com.hospedagem.sistema.domain.GuestStatus;
import com.hospedagem.sistema.domain.Payment;
import com.hospedagem.sistema.domain.PaymentStatus;
import com.hospedagem.sistema.dto.PaymentRequestDTO;
import com.hospedagem.sistema.dto.PaymentResponseDTO;
import com.hospedagem.sistema.exception.BusinessException;
import com.hospedagem.sistema.exception.ResourceNotFoundException;
import com.hospedagem.sistema.repository.GuestRepository;
import com.hospedagem.sistema.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final GuestRepository guestRepository;

    public PaymentResponseDTO create(PaymentRequestDTO dto) {

        // 1. buscar hóspede
        Guest guest = guestRepository.findById(dto.guestId())
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        // 2. validar se já existe pagamento
        if (guest.getPayment() != null) {
            throw new BusinessException("Guest already has a payment");
        }

        // 3. criar pagamento
        Payment payment = new Payment();
        payment.setAmount(dto.amount());
        payment.setStatus(PaymentStatus.valueOf(dto.status()));
        payment.setPaymentDate(LocalDate.now());
        payment.setGuest(guest);

        // 4. atualizar status do hóspede
        if (payment.getStatus() == PaymentStatus.PAID) {
            guest.setStatus(GuestStatus.ACTIVE);
        } else {
            guest.setStatus(GuestStatus.PENDING);
        }

        // 5. salvar
        Payment saved = paymentRepository.save(payment);

        return toResponse(saved);
    }

    public List<PaymentResponseDTO> findAll() {
        return paymentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PaymentResponseDTO findById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        return toResponse(payment);
    }

    private PaymentResponseDTO toResponse(Payment payment) {
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getStatus().name(),
                payment.getGuest().getName()
        );
    }
}
