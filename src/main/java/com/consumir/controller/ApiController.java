package com.consumir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumir.modelo.ApiResponse;
import com.consumir.service.ApiService;
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/api/consumir")
    public String consumeApi(@RequestParam String name) {
        return apiService.callApi(name);
    }
}


