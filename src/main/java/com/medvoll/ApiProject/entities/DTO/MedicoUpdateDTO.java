package com.medvoll.ApiProject.entities.DTO;

import com.medvoll.ApiProject.entities.Endereco;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        String telefone,
        @NotNull
        Endereco endereco,

        Especialidade especialidade
) {
}
