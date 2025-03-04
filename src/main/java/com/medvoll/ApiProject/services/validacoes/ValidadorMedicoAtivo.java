package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(ConsultaDadosDTO dadosDTO){
        System.out.println("Consulta Medico Ativo");

        if (dadosDTO.idMedico() == null){
            return;
        }
        System.out.println("Saindo consulta medico ativo 1 ");
        Optional<Medico> medicoAtivo = medicoRepository.findByIdAndAtivoTrue(dadosDTO.idMedico());
        System.out.println("Saindo consulta medico ativo 2 ");

        if (medicoAtivo.isEmpty()){
            throw new ValidacaoException("Médico selecionado não está disponível");
        }
        System.out.println("Saindo consulta medico ativo 3 ");
    }
}
