package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private PacienteRespository pacienteRespository;

    public void validar(ConsultaDadosDTO dadosDTO){
        var paciente = pacienteRespository.getReferenceById(dadosDTO.idPaciente());
        if (!paciente.getAtivo()){
            throw new ValidacaoException("Paciente selecionado não está disponível")    ;
        }

    }
}
