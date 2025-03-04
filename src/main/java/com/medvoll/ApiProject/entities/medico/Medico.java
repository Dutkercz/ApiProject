package com.medvoll.ApiProject.entities.medico;

import com.medvoll.ApiProject.entities.consulta.Consulta;
import com.medvoll.ApiProject.entities.endereco.Endereco;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public Medico(MedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
        this.ativo = true;
    }

}
