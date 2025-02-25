package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.MedicoDTO;
import com.medvoll.ApiProject.entities.DTO.MedicoListagemDTO;
import com.medvoll.ApiProject.entities.DTO.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import com.medvoll.ApiProject.services.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoListagemDTO> registrationMedico (@RequestBody @Valid MedicoDTO dados,
                                                                 UriComponentsBuilder builder){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = builder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoListagemDTO(medico));
    }

    @GetMapping
    @Transactional
    public Page<MedicoListagemDTO> showAllMedicos (Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicoListagemDTO> getMedico (@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new MedicoListagemDTO(medico));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<MedicoListagemDTO> updateMedico (@RequestBody @Valid MedicoUpdateDTO dados){
        Medico medico = medicoService.update(dados);
        return ResponseEntity.ok(new MedicoListagemDTO(medico));
    }

    @DeleteMapping(value = "{id}")
    @Transactional
    public ResponseEntity<Medico> inactivateMedico (@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.setAtivo(false);
        return ResponseEntity.noContent().build();
    }

}
