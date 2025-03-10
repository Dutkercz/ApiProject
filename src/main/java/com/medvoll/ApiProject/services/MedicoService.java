package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.medico.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;


    public Medico findById(Long id){
       return medicoRepository.getReferenceById(id);
    }


    public Medico update(@Valid MedicoUpdateDTO dados) {
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
        return medico;
    }
}
