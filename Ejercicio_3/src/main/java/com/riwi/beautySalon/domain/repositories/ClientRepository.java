package com.riwi.beautySalon.domain.repositories;

import com.riwi.beautySalon.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long>{
    
    
}
