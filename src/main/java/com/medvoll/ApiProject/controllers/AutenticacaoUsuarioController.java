package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.AutenticacaoUsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AutenticacaoUsuarioController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutenticacaoUsuarioDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var athentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
