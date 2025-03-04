package com.medvoll.ApiProject.entities.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.medvoll.ApiProject.entities.enums.Especialidade;

import java.time.LocalDateTime;

public record ConsultaListagemDTO(Long id, Long idMedico, Long idPaciente,
                                  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")LocalDateTime data, Especialidade especialidade) {
    public ConsultaListagemDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(), consulta.getMedico().getEspecialidade());
    }
}
