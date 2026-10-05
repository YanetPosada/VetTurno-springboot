package com.veturno.veturno.repository;

import com.veturno.veturno.model.Cita;
import com.veturno.veturno.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByVeterinario(Veterinario veterinario);

    boolean existsByVeterinarioAndFechaHora(
            Veterinario veterinario,
            LocalDateTime fechaHora
    );
}