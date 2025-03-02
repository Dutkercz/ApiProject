package com.medvoll.ApiProject.entities;

import com.medvoll.ApiProject.entities.DTO.ConsultaDadosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Paciente paciente;

    private LocalDateTime data;

}
