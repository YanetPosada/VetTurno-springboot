package com.veturno.veturno.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CitaRequest {

    @Future(message = "La fecha debe ser futura")
    private LocalDateTime fechaHora;

    @NotBlank(message = "Motivo obligatorio")
    private String motivo;

    @NotNull(message = "Mascota obligatoria")
    private Long mascotaId;

    @NotNull(message = "Veterinario obligatorio")
    private Long veterinarioId;

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
}
