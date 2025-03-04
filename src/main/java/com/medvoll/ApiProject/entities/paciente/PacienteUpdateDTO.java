package com.medvoll.ApiProject.entities.paciente;

import com.medvoll.ApiProject.entities.endereco.Endereco;
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
