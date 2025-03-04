package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsultas{

    public void validar(ConsultaDadosDTO dadosDTO){
        System.out.println("Consulta Hora antecedencia");
        var horaDoAngendamento = dadosDTO.data() ;
        var horaAtual = LocalDateTime.now();
        var diferençaEmMinutos = Duration.between(horaAtual, horaDoAngendamento).toMinutes();
        if (diferençaEmMinutos < 30){
            throw  new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos.");
        }
        System.out.println("Saindo consulta hora antecedencia");
    }
}
