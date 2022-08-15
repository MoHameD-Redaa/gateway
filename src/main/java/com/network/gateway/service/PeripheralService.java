package com.network.gateway.service;

import com.network.gateway.model.Gateway;
import com.network.gateway.model.Peripheral;
import com.network.gateway.repository.GatewayRepository;
import com.network.gateway.repository.PeripheralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeripheralService {
    @Autowired
    private PeripheralRepository peripheralRepository;

    @Autowired
    private GatewayRepository gatewayRepository;

    public Peripheral createNewPeripheral(String serialNumber, Peripheral peripheral) {

        Optional<Gateway> gateway = gatewayRepository.findById(serialNumber);

        if (gateway.isPresent()) {
            if (gateway.get().getPeripherals().size() < 10) {
                peripheral.setGateway(gateway.get());
                return peripheralRepository.save(peripheral);
            }
        }
        return null;
    }


/*    public ResponseEntity createNewPeripheral(String gateway_serialNo, Peripheral peripheral) {

        Optional<Gateway> gateway = gatewayRepository.findById(gateway_serialNo);

        if (gateway.isPresent()) {
            if (gateway.get().getPeripherals().size() < 10) {
                peripheral.setGateway(gateway.get());
                return new ResponseEntity<>(peripheralRepository.save(peripheral), HttpStatus.OK);
            } else {
                return new ResponseEntity("This gateway have max size!", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Gateway id: " + gateway_serialNo + " was not found", HttpStatus.BAD_REQUEST);
        }
    }*/


        /*Optional<Gateway> gateway = gatewayRepository.findById(gateway_serialNo);
            if (gateway.isPresent()) {
                if (gateway.get().getPeripherals().size() < 10) {
                    peripheral.setGateway(gateway.get());
                    return gateway_serialNo;
                }
            }
            return null;*/
}

