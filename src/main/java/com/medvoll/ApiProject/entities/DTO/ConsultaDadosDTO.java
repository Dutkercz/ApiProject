package com.medvoll.ApiProject.entities.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaDadosDTO(Long idMedico,
                               @NotNull Long idPaciente,
                               @JsonFormat(pattern = "dd/MM/yyyy HH:mm") @NotNull @Future LocalDateTime data,
                               Especialidade especialidade) {
}
