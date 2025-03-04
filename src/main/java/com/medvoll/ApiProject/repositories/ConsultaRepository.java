package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
