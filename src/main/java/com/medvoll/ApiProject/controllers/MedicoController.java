package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.records.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

    @PostMapping
    public void registration(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);
    }

}
