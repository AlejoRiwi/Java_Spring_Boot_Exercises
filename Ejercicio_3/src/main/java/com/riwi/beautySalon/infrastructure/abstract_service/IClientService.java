package com.riwi.beautySalon.infrastructure.abstract_service;

import com.riwi.beautySalon.api.dto.request.ClientRequest;
import com.riwi.beautySalon.api.dto.response.ClientResp;

public interface IClientService extends CrudService<ClientRequest, ClientResp, Long> {
    public String FIELD_BY_SORT = "firstName";
}
