package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.Consulta;
import com.medvoll.ApiProject.entities.DTO.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.entities.Paciente;
import com.medvoll.ApiProject.entities.ValidacaoException;
import com.medvoll.ApiProject.repositories.ConsultaRepository;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRespository pacienteRespository;

    public void agendarConsulta (ConsultaDadosDTO dadosDTO){
        if (dadosDTO.idMedico() != null && !medicoRepository.existsById(dadosDTO.idMedico())){
            throw new ValidacaoException("Médico não encontrado!");
        }
        if (!pacienteRespository.existsById(dadosDTO.idPaciente())){
            throw new ValidacaoException("Paciente não encontrado!");
        }

        Medico medico = escolherMedico(dadosDTO);
        Paciente paciente = pacienteRespository.findById(dadosDTO.idPaciente()).get();

        Consulta consulta = new Consulta(null, medico, paciente, dadosDTO.data());
        consultaRepository.save(consulta);
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
