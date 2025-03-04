package com.medvoll.ApiProject.entities.medico;

import com.medvoll.ApiProject.entities.endereco.EnderecoDTO;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank //not blank apenas para dados string
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull //tem que ser not null, pois não é string
        Especialidade especialidade,

        @NotNull @Valid
        EnderecoDTO endereco) {
}
