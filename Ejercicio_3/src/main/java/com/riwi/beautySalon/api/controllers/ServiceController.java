package com.riwi.beautySalon.api.controllers;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.infrastructure.abstract_service.IServiceService;

import com.riwi.beautySalon.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/service")
@AllArgsConstructor

public class ServiceController {
    @Autowired
    private IServiceService service;

    @
    public ResponseEntity <Page<ServiceResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false)SortType sortType;
    ) {
        if(Object.isNull(sortType)){
            sortype = SortType.NONE;
        }
        return ResponseEntity.ok(this.service.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity <ServiceResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }

    @PostMapping
    public ResponseEntity <ServiceResp> create(@RequestBody ServiceReq request){
        return ResponseEntity.ok(this.sevice.create(request));-

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleted (@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ServiceResp> update (
            @Validated @RequestBody ServiceRequest request,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(this.service.update(request, id));
    }
}
