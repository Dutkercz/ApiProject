package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRespository extends JpaRepository<Paciente, Long> {
}
