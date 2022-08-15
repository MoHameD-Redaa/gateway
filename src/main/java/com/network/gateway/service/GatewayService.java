package com.network.gateway.service;

import com.network.gateway.model.Gateway;
import com.network.gateway.repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatewayService {

    @Autowired
    private GatewayRepository gatewayRepository;


    public List<Gateway> getAllGateways() {
        return gatewayRepository.findAll();
    }

  public Gateway getGatewayById(String serialNumber) {
      Optional<Gateway> gateway = gatewayRepository.findById(serialNumber);
      return gateway.orElse(null);
    }

    // Make Internal Server Error
/*     public Gateway getGatewayById(String serialNumber) {
        return gatewayRepository.findById(serialNumber).get();
    }*/



    public Gateway createNewGateway(Gateway gateway) {
        return gatewayRepository.save(gateway);
    }


    public Gateway updateGatewayById(String serialNumber, Gateway gateway) {
        Optional<Gateway> prevGateway = gatewayRepository.findById(serialNumber);
        if (prevGateway.isPresent()) {

            Gateway newGateway = prevGateway.get();
            newGateway.setName(gateway.getName());
            newGateway.setIpv4(gateway.getIpv4());
            return gatewayRepository.save(newGateway);
        }
        else
            return null;
    }


    public String deleteGatewayById(String serialNumber) {

        Optional<Gateway> gateway = gatewayRepository.findById(serialNumber);
        if (gateway.isPresent())
        {
            gatewayRepository.deleteById(serialNumber);
            return "Gateway serialNumber:" + serialNumber + " was removed successfully";
        }
        else
        {
            return "Gateway id: " + serialNumber + " was not found";
        }
    }


}
