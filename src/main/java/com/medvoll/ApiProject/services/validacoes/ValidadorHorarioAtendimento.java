package com.medvoll.ApiProject.services.validacoes;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAtendimento implements ValidadorAgendamentoDeConsultas{

    public void validar(ConsultaDadosDTO dadosDTO){
        LocalDateTime dataConsulta = dadosDTO.data();
        boolean domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoFechamento = dataConsulta.getHour() > 18;
        if (domingo || antesDaAbertura || depoisDoFechamento){
            throw new ValidacaoException("Consulta fora do horario de atendimento");
        }
    }
}
