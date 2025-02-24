package com.medvoll.ApiProject.entities.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotNull @Valid
        EnderecoDTO endereco
    ) {
}
