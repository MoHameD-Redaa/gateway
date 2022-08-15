package com.network.gateway.controller;

import com.network.gateway.model.Peripheral;
import com.network.gateway.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peripheral")
public class PeripheralController {

    @Autowired
    PeripheralService peripheralService;



    @PostMapping ("/add/{serialNumber}")
    public Peripheral createNewPeripheral(@PathVariable String serialNumber, @RequestBody Peripheral peripheral)
    {
        return peripheralService.createNewPeripheral(serialNumber,peripheral);
    }

}
