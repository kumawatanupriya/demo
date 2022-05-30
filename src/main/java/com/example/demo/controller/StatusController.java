package com.example.demo.controller;

import com.example.demo.InventoryMode;
import com.example.demo.services.ActuatorRefreshService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@NoArgsConstructor
public class StatusController {

    @Autowired
    InventoryMode inventoryMode;

    @Autowired
    ActuatorRefreshService actuatorRefreshService;

    @GetMapping("/mode")
    public String getMethod() throws RuntimeException {
        return inventoryMode.getMode();

    }

    @PostMapping("/v1/mode")
    public void updateMode(@RequestParam String mode) throws RuntimeException {
        System.out.println("current mode +++++++ " + mode);
        actuatorRefreshService.refreshInventoryMode(mode);
    }

}



