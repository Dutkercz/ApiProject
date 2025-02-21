package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.records.DadosCadastroMedico;
import com.medvoll.ApiProject.repositories.MedicoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepositorie medicoRepositorie;

    @PostMapping
    public Medico registration(@RequestBody DadosCadastroMedico dados){
        medicoRepositorie.save(new Medico(dados));
    }

}
