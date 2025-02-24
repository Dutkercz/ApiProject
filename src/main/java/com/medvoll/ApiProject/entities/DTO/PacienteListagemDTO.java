package com.medvoll.ApiProject.entities.DTO;

import com.medvoll.ApiProject.entities.Endereco;

public record PacienteListagemDTO(
        String name,
        Endereco endereco,
        String telefone
) {
}
