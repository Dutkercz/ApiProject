package com.medvoll.ApiProject.entities;

import com.medvoll.ApiProject.entities.enums.Especialidade;
import com.medvoll.ApiProject.DTO.MedicoDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter @AllArgsConstructor @ToString @EqualsAndHashCode(of = "id") @Table(name = "medicos") @Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico() {
    }

    public Medico(MedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
    }

}
