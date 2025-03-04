package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRespository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    Optional<Paciente> findByIdAndAtivo(Long id, boolean b);

    Optional<Paciente> findByIdAndAtivoTrue(Long id);
}
