package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.consulta.ConsultaDadosDTO;
import com.medvoll.ApiProject.entities.consulta.ConsultaListagemDTO;
import com.medvoll.ApiProject.services.ConsultaAgendamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaAgendamentoService consultaAgendamentoService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta (@RequestBody @Valid ConsultaDadosDTO dadosDTO){
        var dto = consultaAgendamentoService.agendarConsulta(dadosDTO);
        return ResponseEntity.ok(dto);

    }
}
