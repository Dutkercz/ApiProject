package com.medvoll.ApiProject.entities.medico;

import com.medvoll.ApiProject.entities.endereco.Endereco;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco,

        Especialidade especialidade
) {
}
