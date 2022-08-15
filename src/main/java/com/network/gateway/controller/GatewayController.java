package com.network.gateway.controller;

import com.network.gateway.model.Gateway;
import com.network.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gateways")
public class GatewayController {

    @Autowired
    GatewayService gatewayService;


    @GetMapping("/all")
    public List<Gateway> getAllGateways() {
        return gatewayService.getAllGateways();
    }

    @GetMapping("/get/{serialNumber}")
    public Gateway getGatewayById(@PathVariable String serialNumber) {
        return gatewayService.getGatewayById(serialNumber);
    }


    @PostMapping("/add")
    public Gateway createNewGateway(@RequestBody Gateway gateway) {
        return gatewayService.createNewGateway(gateway);
    }


    @PutMapping("/update/{serialNumber}")
    public Gateway updateGatewayById(@PathVariable String serialNumber, @Valid @RequestBody Gateway gateway) {
        return gatewayService.updateGatewayById(serialNumber,gateway);
    }


    @DeleteMapping("/del/{serialNumber}")
    public String deleteGatewayById(@Valid @PathVariable String serialNumber) {
        return gatewayService.deleteGatewayById(serialNumber);
    }

}
