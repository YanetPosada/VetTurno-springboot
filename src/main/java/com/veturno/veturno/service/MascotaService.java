package com.veturno.veturno.service;

import com.veturno.veturno.dto.MascotaDTO;
import com.veturno.veturno.model.Mascota;
import com.veturno.veturno.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaDTO> listarMascotas() {

        return mascotaRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public MascotaDTO guardarMascota(Mascota mascota) {

        Mascota guardada =
                mascotaRepository.save(mascota);

        return convertirDTO(guardada);
    }

    private MascotaDTO convertirDTO(Mascota mascota) {

        MascotaDTO dto = new MascotaDTO();

        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());
        dto.setRaza(mascota.getRaza());
        dto.setEdad(mascota.getEdad());

        if (mascota.getPropietario() != null) {

            dto.setPropietarioId(
                    mascota.getPropietario().getId()
            );

            dto.setPropietarioNombre(
                    mascota.getPropietario().getNombre()
            );
        }

        return dto;
    }
}