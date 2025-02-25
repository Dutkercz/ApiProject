package com.medvoll.ApiProject.entities.DTO;

import com.medvoll.ApiProject.entities.Endereco;
import com.medvoll.ApiProject.entities.Paciente;

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
