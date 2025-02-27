package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.entities.DTO.AutenticacaoUsuarioDTO;
import com.medvoll.ApiProject.entities.usuarios.Usuario;
import com.medvoll.ApiProject.infra.security.TokenJWTDTO;
import com.medvoll.ApiProject.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AutenticacaoUsuarioController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutenticacaoUsuarioDTO dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var athentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) athentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }
}
