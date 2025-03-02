package com.medvoll.ApiProject.entities.DTO;

import java.time.LocalDateTime;

public record ConsultaListagemDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
