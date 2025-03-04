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
        System.out.println("Consulta Data Medico");

        var consultas = medicoRepository.getReferenceById(dadosDTO.idMedico()).getConsultas();
        if(consultas.isEmpty()){
            System.out.println("Saindo consulta medico data");
            return;
        }

        var dataConsulta = dadosDTO.data();
        var dataUltimaConsultaDoMedico = consultas.getLast().getData();
        if (dataConsulta.equals(dataUltimaConsultaDoMedico) ){
            throw new ValidacaoException("Data da consulta indiponível para este médico.");
        }
    }
}
