package com.medvoll.ApiProject.entities.medico;

import com.medvoll.ApiProject.entities.enums.Especialidade;

public record MedicoListagemDTO(Long id,
                                String nome,
                                String email,
                                String crm,
                                String telefone,
                                Especialidade especialidade
                                ) {

    public MedicoListagemDTO (Medico medico){
        this(medico.getId(),medico.getNome(), medico.getEmail(),
                medico.getCrm(), medico.getTelefone(), medico.getEspecialidade());
    }

}
