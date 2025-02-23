package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.PacienteDTO;
import com.medvoll.ApiProject.entities.Paciente;
import com.medvoll.ApiProject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public void registration (@RequestBody @Valid PacienteDTO paciente){
        pacienteService.save(paciente);
    }
}
