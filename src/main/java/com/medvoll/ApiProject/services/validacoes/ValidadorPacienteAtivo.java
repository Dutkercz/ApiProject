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
        System.out.println("CONSULTA paciente ativo");
        pacienteRespository.findByIdAndAtivoTrue(dadosDTO.idPaciente())
                .orElseThrow(() -> new ValidacaoException("Paciente está inativo!"));
        System.out.println("Saindo consulta paciente ativo 1 ");


    }
}
