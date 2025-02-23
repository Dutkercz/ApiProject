package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.DTO.PacienteDTO;
import com.medvoll.ApiProject.entities.Paciente;
import com.medvoll.ApiProject.repositories.PacienteRespository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRespository pacienteRespository;

    @Transactional
    public void save(@Valid PacienteDTO paciente) {
        pacienteRespository.save(new Paciente(paciente));
    }
}
