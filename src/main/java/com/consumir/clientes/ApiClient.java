package com.consumir.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.consumir.modelo.ApiResponse;

@FeignClient(name = "apiClient", url = "https://sisedevco.ikeasistencia.com/api-swagger/api/v1/controller")
public interface ApiClient {
	
	 @GetMapping("/test")
	 ResponseEntity<ApiResponse> getResponse(@RequestParam("name") String name);
}
