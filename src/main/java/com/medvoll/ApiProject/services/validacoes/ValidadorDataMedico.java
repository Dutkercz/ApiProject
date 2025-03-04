package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDataMedico implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(ConsultaDadosDTO dadosDTO){
        var medico = medicoRepository.getReferenceById(dadosDTO.idMedico());
        var dataConsulta = dadosDTO.data();
        var dataUltimaConsultaDoMedico = medico.getConsultas().getLast().getData();
        if (dataConsulta == dataUltimaConsultaDoMedico ){
            throw new ValidacaoException("Data da consulta indiponível para este médico.");

        }
    }
}
