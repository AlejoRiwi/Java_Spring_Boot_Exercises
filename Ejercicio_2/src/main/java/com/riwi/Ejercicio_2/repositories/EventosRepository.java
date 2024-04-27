package com.riwi.Ejercicio_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Ejercicio_2.entities.Eventos;

public interface EventosRepository  extends JpaRepository<Eventos, Long>{
    public Eventos findByName (String name);
} 
