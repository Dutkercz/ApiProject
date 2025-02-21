package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.MedicoDTO;
import com.medvoll.ApiProject.entities.DTO.MedicoListagemDTO;
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
    public Page<MedicoListagemDTO> showAll (@PageableDefault(sort = "nome") Pageable paginacao){
        return medicoRepositorie.findAll(paginacao).map(MedicoListagemDTO::new);
    }

}
