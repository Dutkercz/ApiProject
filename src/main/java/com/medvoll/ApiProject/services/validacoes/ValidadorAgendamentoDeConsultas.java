package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;

public interface ValidadorAgendamentoDeConsultas {
    void validar(ConsultaDadosDTO dadosDTO);
}
