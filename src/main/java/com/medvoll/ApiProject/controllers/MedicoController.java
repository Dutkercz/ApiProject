package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.MedicoDTO;
import com.medvoll.ApiProject.entities.DTO.MedicoListagemDTO;
import com.medvoll.ApiProject.entities.DTO.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.repositories.MedicoRepositorie;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepositorie medicoRepositorie;

    @PostMapping
    @Transactional
    public void registration(@RequestBody @Valid MedicoDTO dados){
        medicoRepositorie.save(new Medico(dados));
    }

    @GetMapping
    @Transactional
    public Page<MedicoListagemDTO> showAll (Pageable paginacao){
        return medicoRepositorie.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid MedicoUpdateDTO dados){
        Medico medico = medicoRepositorie.getReferenceById(dados.id());
        medico.update(dados);
    }

    @DeleteMapping(value = "{id}")
    @Transactional
    public void delete (@PathVariable Long id){
        Medico medico = medicoRepositorie.getReferenceById(id);
        medico.setAtivo(false);
    }

}
