package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ActuatorRefreshService {

    private final String inventoryModeKey = "inventory.initial.mode";

    @Autowired
    public ActuatorRefreshService() {
    }

    public void refreshInventoryMode(String latestMode) {
        Map<String, String> bodyMap = new HashMap();
        bodyMap.put("name",inventoryModeKey);
        bodyMap.put("value",latestMode);
        final String url = "http://localhost:8080/actuator/busenv";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Object> entity = new HttpEntity<>(bodyMap, headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("call actuator endpoint to update the value ");

    }

}
