package com.riwi.beautySalon.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResp {
    private Long id;
    private String name;
    private String description;
    private String price;
}
