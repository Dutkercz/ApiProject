package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.DTO.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.repositories.MedicoRepositorie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepositorie medicoRepositorie;


    public Medico findById(Long id){
       return medicoRepositorie.getReferenceById(id);
    }


    public void update(@Valid MedicoUpdateDTO dados) {
        Medico medico = findById(dados.id());
        if(dados.nome() != null) {
            medico.setNome(dados.nome());
        }
        if(dados.telefone() != null) {
            medico.setTelefone(dados.telefone());
        }
        if(dados.endereco() != null) {
            medico.setEndereco(dados.endereco());
        }
    }
}
