package com.network.gateway.repository;

import com.network.gateway.model.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, String> {
/*
    To create new method for finding gateway
    public Gateway findByName(String name);
    public Gateway findByNameAndSerialNumber(String name,String serialNumber);
*/
}
