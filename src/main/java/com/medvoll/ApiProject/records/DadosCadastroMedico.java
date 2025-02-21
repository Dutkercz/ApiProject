package com.medvoll.ApiProject.records;

import com.medvoll.ApiProject.enums.Especialidade;

public record DadosCadastroMedico(String nome, String email,
                                  String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {
}
