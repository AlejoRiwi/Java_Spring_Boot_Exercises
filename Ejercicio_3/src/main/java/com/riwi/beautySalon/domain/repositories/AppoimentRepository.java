package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.beautySalon.domain.entities.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppoimentRepository extends JpaRepository <Appointment, Long>{
    @Query("select p from appoinment p join fetch p.client c where c.id = :idClient")
    public Optional <Appointment> findByClientId(Long idClient);
}
