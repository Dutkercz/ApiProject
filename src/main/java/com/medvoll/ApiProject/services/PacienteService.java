package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.DTO.PacienteDTO;
import com.medvoll.ApiProject.entities.DTO.PacienteListagemDTO;
import com.medvoll.ApiProject.entities.Paciente;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRespository pacienteRespository;

    @Transactional
    public void save(@Valid PacienteDTO paciente) {
        pacienteRespository.save(new Paciente(paciente));
    }

//    public PacienteDTO findById(Long id) {
//
//    }

    public Page<PacienteListagemDTO> findAll(Pageable pageable) {
        Page<Paciente> pacientes = pacienteRespository.findAllByAtivoTrue(pageable);
        return pacientes.map(x -> new PacienteListagemDTO(x.getNome(), x.getEndereco(), x.getTelefone()));
    }
}
