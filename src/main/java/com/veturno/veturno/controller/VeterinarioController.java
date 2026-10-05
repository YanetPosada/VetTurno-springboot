package com.veturno.veturno.controller;

import com.veturno.veturno.dto.VeterinarioDTO;
import com.veturno.veturno.model.Veterinario;
import com.veturno.veturno.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public List<VeterinarioDTO> listarVeterinarios() {
        return veterinarioService.listarVeterinarios();
    }

    @PostMapping
    public VeterinarioDTO guardarVeterinario(
            @RequestBody Veterinario veterinario) {

        return veterinarioService.guardarVeterinario(veterinario);
    }
}
