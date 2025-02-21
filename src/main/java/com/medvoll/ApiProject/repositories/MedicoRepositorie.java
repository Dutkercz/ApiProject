package com.medvoll.ApiProject.repositories;

import com.medvoll.ApiProject.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepositorie extends JpaRepository<Medico, Long> {
}
