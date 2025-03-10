package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.medico.Medico;
import com.medvoll.ApiProject.entities.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT m FROM Medico m
            where
            m.ativo = true
            and
            m.especialidade = :especialidade
            and
            m.id not in (
                select c.medico.id from Consulta c
                where c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioDisponivel(Especialidade especialidade, @NotNull @Future LocalDateTime data);

    Optional<Medico> findByIdAndAtivoTrue(Long id);
}
