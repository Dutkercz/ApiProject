package com.medvoll.ApiProject.entities.paciente;


import com.medvoll.ApiProject.entities.consulta.Consulta;
import com.medvoll.ApiProject.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String nome;
    @Setter
    private String email;
    @Setter
    private String telefone;
    private String cpf;

    @Embedded
    @Setter
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    private Boolean ativo;

    public Paciente(PacienteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void setInactive() {
        this.ativo = false;
    }
}
