package com.veturno.veturno.dto;

import java.time.LocalDateTime;

public class CitaDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private Long mascotaId;
    private String mascotaNombre;
    private Long veterinarioId;
    private String veterinarioNombre;
    private String propietarioNombre;

    public CitaDTO() {
    }

    public CitaDTO(
            Long id,
            LocalDateTime fechaHora,
            String motivo,
            Long mascotaId,
            String mascotaNombre,
            Long veterinarioId,
            String veterinarioNombre,
            String propietarioNombre) {

        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.mascotaId = mascotaId;
        this.mascotaNombre = mascotaNombre;
        this.veterinarioId = veterinarioId;
        this.veterinarioNombre = veterinarioNombre;
        this.propietarioNombre = propietarioNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public String getVeterinarioNombre() {
        return veterinarioNombre;
    }

    public void setVeterinarioNombre(String veterinarioNombre) {
        this.veterinarioNombre = veterinarioNombre;
    }

    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public void setPropietarioNombre(String propietarioNombre) {
        this.propietarioNombre = propietarioNombre;
    }
}