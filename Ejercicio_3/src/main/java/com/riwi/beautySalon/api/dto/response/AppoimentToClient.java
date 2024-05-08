package com.riwi.beautySalon.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppoimentToClient {
    private Long id;
    private LocalDateTime dataTime;
    private Integer duration;
    private String comments;
    private ServiceResp service;
    private EmployeeRespo employee;
}
