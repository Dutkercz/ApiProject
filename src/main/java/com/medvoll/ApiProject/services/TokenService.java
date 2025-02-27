package com.medvoll.ApiProject.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.medvoll.ApiProject.entities.usuarios.Usuario;
import org.apache.catalina.util.Strftime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${senha.algoritimo.autenticacao}")
    private String secret;

    public String gerarToken (Usuario usuario){
        System.out.println(secret);
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(usuario.getLogin())
//                    .withClaim("id", usuario.getId()) pode usar varios withClaim, no estilo chave-valor
                    .withExpiresAt(dataExpiração())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    private Instant dataExpiração() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
