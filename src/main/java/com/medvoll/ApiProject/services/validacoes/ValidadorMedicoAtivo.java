package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(ConsultaDadosDTO dadosDTO){

        if (dadosDTO.idMedico() == null){
            return;
        }

        var medicoAtivo = medicoRepository.findAtivoById(dadosDTO.idMedico());

        if (!medicoAtivo){
            throw new ValidacaoException("Médico selecionado não está disponível");
        }
    }
}
