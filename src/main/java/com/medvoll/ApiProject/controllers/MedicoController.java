package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.DTO.MedicoDTO;
import com.medvoll.ApiProject.repositories.MedicoRepositorie;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<MedicoListagemDTO> showAll (){
        return medicoRepositorie.findAll()
                .stream()
                .map(MedicoListagemDTO::new).collect(Collectors.toList());
    }

}
