package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientRequest {
    @NotBlank(message = "El nombre es requerido")
    private String firstName;
    @NotBlank(message = "El apellido es requerido")
    private String LasttName;
    @Size(min = 10, max = 12, message = "El numero debe de tener entre 10 y 20 caracteres")
    private String phone;
    @Email(message = "El email no es valido ")
    @Size(min = 5, max = 100, message = "el email debe tener entre 5 y 100 caracteres")
    private String email;
}
