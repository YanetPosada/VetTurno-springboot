package com.veturno.veturno.service;

import com.veturno.veturno.dto.VeterinarioDTO;
import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<VeterinarioDTO> listarVeterinarios() {
        return veterinarioRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public VeterinarioDTO guardarVeterinario(Veterinario veterinario) {
        Veterinario guardado = veterinarioRepository.save(veterinario);
        return convertirDTO(guardado);
    }

    private VeterinarioDTO convertirDTO(Veterinario veterinario) {

        VeterinarioDTO dto = new VeterinarioDTO();

        dto.setId(veterinario.getId());
        dto.setNombre(veterinario.getNombre());
        dto.setEspecialidad(veterinario.getEspecialidad());

        return dto;
    }
}