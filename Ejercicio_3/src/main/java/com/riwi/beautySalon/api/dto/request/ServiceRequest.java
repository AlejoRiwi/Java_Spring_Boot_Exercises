package com.riwi.beautySalon.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    @NotBlank( message = "El nombre del servicio es requerido")
    private String name;
    private String description;
    @DecimalMin(value = "0.1", message = "el valor del servicio debe de ser mayor")
    private BigDecimal price;
}
