package com.medvoll.ApiProject.entities.DTO;

import com.medvoll.ApiProject.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
        @NotNull
        Long id,

        String nome,

        Endereco endereco,

        String telefone,

        String email
) {
}
