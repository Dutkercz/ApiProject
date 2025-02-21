package com.medvoll.ApiProject.entities.DTO;

import com.medvoll.ApiProject.entities.Medico;
import com.medvoll.ApiProject.entities.enums.Especialidade;

public record MedicoListagemDTO(String nome,
                                String email,
                                String crm,
                                Especialidade especialidade) {

    public MedicoListagemDTO (Medico medico){
        this(medico.getNome(), medico.getEmail(),
                medico.getCrm(), medico.getEspecialidade());
    }

}
