package com.medvoll.ApiProject.entities;

import com.medvoll.ApiProject.entities.DTO.MedicoUpdateDTO;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import com.medvoll.ApiProject.entities.DTO.MedicoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
        this.ativo = true;
    }

    public void update(@Valid MedicoUpdateDTO dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.nome();
        }
        if(dados.endereco() != null) {
            this.endereco.updateEndereco(dados.endereco());
        }
    }
}
