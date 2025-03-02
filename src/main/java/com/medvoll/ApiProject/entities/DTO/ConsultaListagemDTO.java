package com.medvoll.ApiProject.entities.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ConsultaListagemDTO(Long id, Long idMedico, Long idPaciente,
                                  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")LocalDateTime data) {
}
