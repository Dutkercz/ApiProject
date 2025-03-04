package com.medvoll.ApiProject.entities.consulta;

import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ConsultaDadosDTO(Long idMedico,
                               @NotNull Long idPaciente,
                               @DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm") @NotNull @Future LocalDateTime data,
                               Especialidade especialidade) {
}
