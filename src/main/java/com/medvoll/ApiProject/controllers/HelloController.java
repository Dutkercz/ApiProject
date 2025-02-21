package com.medvoll.ApiProject.controllers;

import com.medvoll.ApiProject.records.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping
    public String hello (){
        return "Hello World, i coming to be a dev";
    }

}
