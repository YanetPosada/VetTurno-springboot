package com.veturno.veturno.controller;

import com.veturno.veturno.dto.CitaDTO;
import com.veturno.veturno.model.Cita;
import com.veturno.veturno.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<CitaDTO> listarCitas() {

        return citaService.listarCitas();
    }

    @PostMapping
    public CitaDTO guardarCita(
            @RequestBody Cita cita) {

        return citaService.guardarCita(cita);
    }

    @GetMapping("/veterinario/{id}")
    public List<CitaDTO> buscarPorVeterinario(
            @PathVariable Long id) {

        return citaService.buscarPorVeterinario(id);
    }
}