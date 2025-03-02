package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.DTO.ConsultaListagemDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta (@RequestBody @Valid ConsultaDadosDTO dadosDTO){

        return ResponseEntity.ok( new ConsultaListagemDTO(null, null, null, null));

    }
}
