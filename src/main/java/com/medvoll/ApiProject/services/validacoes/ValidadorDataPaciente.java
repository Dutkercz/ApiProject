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
        System.out.println("Consulta Data Paciente");
        var consultasPaciente = pacienteRespository.getReferenceById(dadosDTO.idPaciente()).getConsultas();
        if (consultasPaciente.isEmpty()){
            System.out.println("Saindo consulta paciente data");
            return;
        }

        var dataConsultaAtual = dadosDTO.data();
        var ultimaConsultaPaciente = consultasPaciente.getLast().getData();
        if (dataConsultaAtual.equals(ultimaConsultaPaciente)){
            throw new ValidacaoException("Já existe uma consulta para este paciente na data selecionada");
        }

    }
}
