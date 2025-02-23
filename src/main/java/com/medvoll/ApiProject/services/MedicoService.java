package com.medvoll.ApiProject.services;

import com.medvoll.ApiProject.entities.DTO.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.Endereco;
import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.repositories.MedicoRepositorie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepositorie medicoRepositorie;
    private Medico medico;
    private Endereco endereco;

    public void findById(Long id){
       medico = medicoRepositorie.getReferenceById(id);
    }

    public void update(@Valid MedicoUpdateDTO dados) {
        if(dados.nome() != null) {
            medico.setNome(dados.nome());
        }
        if(dados.telefone() != null) {
            medico.setTelefone(dados.nome());
        }
        if(dados.endereco() != null) {
            medico.setEndereco(endereco.updateEndereco(dados.endereco()));
        }
    }
}
