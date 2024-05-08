package com.riwi.beautySalon.api.dto.response;

import java.time.LocalDateTime;

public class AppointmenResp {
    private Long id;
    private LocalDateTime dateTime;
    private Integer duration;
    private String comments;


    private BasicClientResomse client;
    private ServiceResp service;
    private EmployeeRespo employee;
}
