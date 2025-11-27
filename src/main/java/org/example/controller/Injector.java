package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.DI.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Injector {

    private final ClientService dependentClientService;

    @GetMapping("/")
    public String sayHello() {
        return "Spring Boot";
    }

    @GetMapping("/client-info")
    public String getClientInfo() {
        String clientInstanceInfo = dependentClientService.toString();
        dependentClientService.executeClientLogic();
        return "ClientService Instance = " + clientInstanceInfo;
    }
}