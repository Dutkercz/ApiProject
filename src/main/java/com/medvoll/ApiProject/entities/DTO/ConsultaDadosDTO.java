package com.medvoll.ApiProject.entities.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaDadosDTO(Long idMedico, @NotNull Long idPaciente, @NotNull @Future LocalDateTime data) {
}
