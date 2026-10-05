package com.veturno.veturno.controller;

import com.veturno.veturno.dto.MascotaDTO;
import com.veturno.veturno.model.Mascota;
import com.veturno.veturno.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<MascotaDTO> listarMascotas() {
        return mascotaService.listarMascotas();
    }

    @PostMapping
    public MascotaDTO guardarMascota(@RequestBody Mascota mascota) {
        return mascotaService.guardarMascota(mascota);
    }
}