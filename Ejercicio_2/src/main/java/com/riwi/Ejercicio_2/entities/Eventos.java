package com.riwi.Ejercicio_2.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eventos {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Date fecha;
    private String ubicacion;
    private int capacidad;
}
