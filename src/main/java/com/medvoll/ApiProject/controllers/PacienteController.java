package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.PacienteDTO;
import com.medvoll.ApiProject.entities.DTO.PacienteListagemDTO;
import com.medvoll.ApiProject.entities.DTO.PacienteUpdateDTO;
import com.medvoll.ApiProject.entities.Paciente;
import com.medvoll.ApiProject.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public void registration (@RequestBody @Valid PacienteDTO paciente){
        pacienteService.save(paciente);
    }

    @GetMapping()
    public Page<PacienteListagemDTO> ListAllPacientes (Pageable pageable){
        return pacienteService.findAll(pageable);
    }
    @GetMapping("/{id}")
    public PacienteListagemDTO findById (@PathVariable Long id){
        return pacienteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void inactivatePaciente (@PathVariable Long id){
        pacienteService.inactivatePaciente(id);
    }

    @PutMapping()
    public void updatePaciente (@RequestBody @Valid PacienteUpdateDTO pacienteDados){
        pacienteService.updatePaciente(pacienteDados);

    }

}
