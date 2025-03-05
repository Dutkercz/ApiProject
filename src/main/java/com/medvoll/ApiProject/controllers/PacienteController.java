package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.paciente.PacienteDTO;
import com.medvoll.ApiProject.entities.paciente.PacienteListagemDTO;
import com.medvoll.ApiProject.entities.paciente.PacienteUpdateDTO;
import com.medvoll.ApiProject.entities.paciente.Paciente;
import com.medvoll.ApiProject.services.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteListagemDTO> registration (@RequestBody @Valid PacienteDTO dadosPaciente,
                                                             UriComponentsBuilder builder){
        Paciente paciente = new Paciente(dadosPaciente);
        pacienteService.save(dadosPaciente);
        URI uri = builder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteListagemDTO(paciente));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PacienteListagemDTO>> ListAllPacientes (Pageable pageable){
        return ResponseEntity.ok(pacienteService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacienteListagemDTO> findById (@PathVariable Long id){
        return ResponseEntity.ok().body(pacienteService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> inactivatePaciente (@PathVariable Long id){
        pacienteService.inactivatePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<PacienteListagemDTO> updatePaciente (@RequestBody @Valid PacienteUpdateDTO pacienteDados){
        var paciente = pacienteService.updatePaciente(pacienteDados);
        return ResponseEntity.ok(new PacienteListagemDTO(paciente));

    }

}
