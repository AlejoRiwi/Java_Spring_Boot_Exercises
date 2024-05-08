package com.riwi.beautySalon.infrastructure.abstract_service;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResp;

import java.util.List;

public interface IServiceService extends CrudService<ServiceRequest, ServiceResp, Long> {
    public List<ServiceResp> search (String name);
    public String FIELD_BY_SORT = "price";
}
