package com.medvoll.ApiProject.entities;


import com.medvoll.ApiProject.entities.DTO.MedicoDTO;
import com.medvoll.ApiProject.entities.DTO.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
