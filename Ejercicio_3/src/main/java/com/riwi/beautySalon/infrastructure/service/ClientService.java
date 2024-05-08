package com.riwi.beautySalon.infrastructure.service;

import com.riwi.beautySalon.api.dto.request.ClientRequest;
import com.riwi.beautySalon.api.dto.response.AppoimentToClient;
import com.riwi.beautySalon.api.dto.response.ClientResp;
import com.riwi.beautySalon.api.dto.response.EmployeeRespo;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.entities.Appointment;
import com.riwi.beautySalon.domain.entities.ClientEntity;
import com.riwi.beautySalon.domain.repositories.ClientRepository;
import com.riwi.beautySalon.infrastructure.abstract_service.IClientService;
import com.riwi.beautySalon.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    @Autowired
    private final ClientRepository clienteRepository;

    @Override
    public ClientResp create(ClientRequest request) {
        return null;
    }

    @Override
    public ClientResp get(Long aLong) {
        return null;
    }

    @Override
    public ClientResp update(ClientRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<ClientResp> getAll(int page, int size, SortType sortType) {
        if (page < 0 ) page = 0;
        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page,size);
            case ASC -> pagination = PageRequest.of(page,size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC ->  pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.clienteRepository.findAll(pagination).map();
    }

    private ClientResp entityToResponse(ClientEntity entity) {
        List<AppointmentToClient> appointments = entity.getAppoiments()
                .stream()
                .map(this::entiyToResponseAppointment)
                .collect(Collectors.toList());

        return ClientResp.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName)
        .lastName(entity.getLastName)
        .phone(entity.getPhone)
        .email(entity.getEmail)
        .appoiments(appointments)
        .build();
    }

    private AppoimentToClient entiyToResponseAppointment (Appointment entity) {
        ServiceResp service = new ServiceResp();
        BeanUtils.copyProperties(entity.getService(),service);

        EmployeeRespo employee = new EmployeeRespo();
        BeanUtils.copyProperties(entity.getEmployee(),employee);
        return AppoimentToClient.builder()
                .id(entity.getId())
                .dateTime(entity.getDataTime())
                .duration(entity.getDuration())
                .comments(entity.getComments())
                .service(service)
                .employee(employee)
                .build();
    }
}
