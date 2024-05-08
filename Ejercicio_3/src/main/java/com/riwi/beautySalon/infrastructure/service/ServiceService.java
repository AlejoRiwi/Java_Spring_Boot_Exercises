package com.riwi.beautySalon.infrastructure.service;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.entities.ServiceEntity;
import com.riwi.beautySalon.domain.repositories.ServiceRepository;
import com.riwi.beautySalon.infrastructure.abstract_service.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;
import com.riwi.beautySalon.utils.exception.BadRequestException;
import com.riwi.beautySalon.utils.messages.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ServiceService implements IServiceService {

    @Autowired
    private final ServiceRepository serviceRepository;
    @Override
    public ServiceResp create(ServiceRequest request) {
        ServiceEntity service =this.requestToEntity(request);

        return this.entityToResp(this.serviceRepository.save(service));
    }

    @Override
    public ServiceResp get(Long id) {
        return this.entityToResp((this.find(id)));
    }

    @Override
    public ServiceResp update(ServiceRequest request, Long id) {
        ServiceEntity service = this.find(id);

        service.setId(id);


        return this.entityToResp(this.serviceRepository.save(service));
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<ServiceResp> getAll(int page, int size, SortType sortType) {
        if(page < 0) page = 0;
        PageRequest pagination = null;
        switch (sortType) {
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case NONE -> pagination = PageRequest.of(page, size);
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        this.serviceRepository.findAll(pagination).map(this::entityToResp);
        return null;
    }

    @Override
    public List<ServiceResp> search(String name) {

        return null;
    }

    private ServiceResp entityToResp(ServiceEntity entity) {
        return ServiceResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }


    private ServiceEntity requestToEntity (ServiceRequest request) {
        return ServiceEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();
    }

    private ServiceEntity find (Long id) {
        return this.serviceRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("servicio")));
    }
}
