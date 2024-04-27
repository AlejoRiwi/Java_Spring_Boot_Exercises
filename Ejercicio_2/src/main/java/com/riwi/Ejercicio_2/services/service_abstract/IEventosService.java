package com.riwi.Ejercicio_2.services.service_abstract;

import java.util.List;
import com.riwi.Ejercicio_2.entities.Eventos;

public interface IEventosService {
    public Eventos save(Eventos eventos);
    public List<Eventos> getAll();
    public Eventos findById(Long id);
    public void delete(Long id);

    public Eventos update(Eventos eventos, Long id);
    public List<Eventos> findByNombre(String nombre);
} 
