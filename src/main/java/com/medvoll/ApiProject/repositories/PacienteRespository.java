package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.Paciente;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRespository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    Optional<Paciente> findByIdAndAtivoTrue(@NotNull Long id);
}
