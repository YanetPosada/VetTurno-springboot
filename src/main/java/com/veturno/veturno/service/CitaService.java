package com.veturno.veturno.service;

import com.veturno.veturno.dto.CitaDTO;
import com.veturno.veturno.model.Cita;
import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.repository.CitaRepository;
import com.veturno.veturno.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<CitaDTO> listarCitas() {

        return citaRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public CitaDTO guardarCita(Cita cita) {

        if (cita.getFechaHora()
                .isBefore(LocalDateTime.now())) {

            throw new RuntimeException(
                    "No se permiten citas en fechas pasadas"
            );
        }

        if (citaRepository
                .existsByVeterinarioAndFechaHora(
                        cita.getVeterinario(),
                        cita.getFechaHora())) {

            throw new RuntimeException(
                    "El veterinario ya tiene una cita en ese horario"
            );
        }

        Cita guardada =
                citaRepository.save(cita);

        return convertirDTO(guardada);
    }

    public List<CitaDTO> buscarPorVeterinario(
            Long veterinarioId) {

        Veterinario veterinario =
                veterinarioRepository
                        .findById(veterinarioId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Veterinario no encontrado"
                                )
                        );

        return citaRepository
                .findByVeterinario(veterinario)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    private CitaDTO convertirDTO(
            Cita cita) {

        CitaDTO dto = new CitaDTO();

        dto.setId(cita.getId());
        dto.setFechaHora(cita.getFechaHora());
        dto.setMotivo(cita.getMotivo());

        if (cita.getMascota() != null) {

            dto.setMascotaId(
                    cita.getMascota().getId()
            );

            dto.setMascotaNombre(
                    cita.getMascota().getNombre()
            );

            if (cita.getMascota().getPropietario() != null) {

                dto.setPropietarioNombre(
                        cita.getMascota()
                                .getPropietario()
                                .getNombre()
                );
            }
        }

        if (cita.getVeterinario() != null) {

            dto.setVeterinarioId(
                    cita.getVeterinario().getId()
            );

            dto.setVeterinarioNombre(
                    cita.getVeterinario().getNombre()
            );
        }

        return dto;
    }
}