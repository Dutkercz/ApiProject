package com.medvoll.ApiProject.entities.consulta;

import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.entities.paciente.Paciente;
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
