package com.medvoll.ApiProject.entities.paciente;

import com.medvoll.ApiProject.entities.endereco.Endereco;

public record PacienteListagemDTO(
        String name,
        Endereco endereco,
        String telefone,
        String email
) {
    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEndereco(), paciente.getTelefone(), paciente.getEmail());
    }
}
