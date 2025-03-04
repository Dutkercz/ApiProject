package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.paciente.PacienteDTO;
import com.medvoll.ApiProject.entities.paciente.PacienteListagemDTO;
import com.medvoll.ApiProject.entities.paciente.PacienteUpdateDTO;
import com.medvoll.ApiProject.entities.paciente.Paciente;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRespository pacienteRespository;

    @Transactional
    public void save(@Valid PacienteDTO paciente) {
        pacienteRespository.save(new Paciente(paciente));
    }

    public PacienteListagemDTO findById(Long id) {
        Paciente paciente = pacienteRespository.findByIdAndAtivoTrue(id).
                orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado. "));
        return new PacienteListagemDTO(paciente.getNome(), paciente.getEndereco(),
                paciente.getTelefone(), paciente.getEmail());
    }

    public Page<PacienteListagemDTO> findAll(Pageable pageable) {
        Page<Paciente> pacientes = pacienteRespository.findAllByAtivoTrue(pageable);
        return pacientes.map(x -> new PacienteListagemDTO(x.getNome(), x.getEndereco(), x.getTelefone(), x.getEmail()));
    }

    @Transactional
    public void inactivatePaciente(Long id) {
        Paciente paciente = pacienteRespository.getReferenceById(id);
        paciente.setInactive();
    }

    @Transactional
    public Paciente updatePaciente(@Valid PacienteUpdateDTO pacienteDados) {
        Paciente paciente = pacienteRespository.getReferenceById(pacienteDados.id());

        if(pacienteDados.nome() != null) {
            paciente.setNome(pacienteDados.nome());
        }
        if(pacienteDados.telefone() != null) {
            paciente.setTelefone(pacienteDados.telefone());
        }
        if(pacienteDados.email() != null){
            paciente.setEmail(pacienteDados.email());
        }
        if(pacienteDados.endereco() != null) {
            paciente.setEndereco(pacienteDados.endereco());
        }
        return paciente;
    }
}
