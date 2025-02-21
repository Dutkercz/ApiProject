package com.medvoll.ApiProject.entities;

import com.medvoll.ApiProject.enums.Especialidade;
import com.medvoll.ApiProject.records.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        email = dados.email();
        crm = dados.crm();
        endereco = new Endereco(dados.endereco());


    }
}
