package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDataPaciente implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private PacienteRespository pacienteRespository;

    public void validar(ConsultaDadosDTO dadosDTO){
        var data = dadosDTO.data().getDayOfYear();
        var paciente = pacienteRespository.getReferenceById(dadosDTO.idPaciente());
        var dataUltimaConsultaPaciente = paciente.getConsultas().getLast().getData().getDayOfYear();
        if (data == dataUltimaConsultaPaciente){
            throw new ValidacaoException("Já existe uma consulta para este paciente na data selecionada");
        }

    }
}
