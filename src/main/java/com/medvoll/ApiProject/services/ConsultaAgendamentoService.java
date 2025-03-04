package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.consulta.Consulta;
import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.consulta.ConsultaListagemDTO;
import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.entities.paciente.Paciente;
import com.medvoll.ApiProject.infra.exception.ValidacaoException;
import com.medvoll.ApiProject.repositories.ConsultaRepository;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import com.medvoll.ApiProject.services.validacoes.ValidadorAgendamentoDeConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaAgendamentoService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRespository pacienteRespository;
    @Autowired
    private List<ValidadorAgendamentoDeConsultas> validadores;

    public ConsultaListagemDTO agendarConsulta (ConsultaDadosDTO dadosDTO){
        if (dadosDTO.idMedico() != null && !medicoRepository.existsById(dadosDTO.idMedico())){
            throw new ValidacaoException("Médico não encontrado!");
        }
        if (!pacienteRespository.existsById(dadosDTO.idPaciente())){
            throw new ValidacaoException("Paciente não encontrado!");
        }

        validadores.forEach(x -> x.validar(dadosDTO));

        Medico medico = escolherMedico(dadosDTO);
        Paciente paciente = pacienteRespository.findById(dadosDTO.idPaciente()).get();
        Consulta consulta = new Consulta(null, medico, paciente, dadosDTO.data());
        consultaRepository.save(consulta);

        return new ConsultaListagemDTO(consulta);

    }

    private Medico escolherMedico(ConsultaDadosDTO dadosDTO) {
        if(dadosDTO.idMedico() != null){
            return medicoRepository.getReferenceById(dadosDTO.idMedico());
        }
        if (dadosDTO.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória se o médico não for selecionado");
        }

        return medicoRepository.escolherMedicoAleatorioDisponivel(dadosDTO.especialidade(), dadosDTO.data());
    }
}
