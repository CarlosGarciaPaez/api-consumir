package com.consumir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.consumir.clientes.ApiClient;
import com.consumir.modelo.ApiResponse;

import feign.FeignException;

@Service
public class ApiService {

    @Autowired
    private ApiClient apiClient;

    public String callApi(String name) {
        try {
            // Realiza la solicitud a la API externa usando Feign
            ResponseEntity<ApiResponse> response = apiClient.getResponse(name);

            // Valida el código de respuesta
            if (response.getStatusCode() == HttpStatus.FOUND) { // 302
                // Extrae el nombre del JSON en la respuesta
                ApiResponse apiResponse = response.getBody();
                String output = "Nombre encontrado: " + apiResponse.getNombre();

               
                System.out.println(output);

                String[] parts = output.split(": ");
                if (parts.length > 1) {
                    String nombre = parts[1];
                    System.out.println("Nombre extraído usando split: " + nombre);
                }

                return output;

            } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) { // 404
                String message = "Sin resultados.";
                System.out.println(message);
                return message;

            } else {
                String message = "Código de respuesta no esperado: ";
                System.out.println(message);
                return message;
            }

        } catch (FeignException e) {
            // Maneja excepciones específicas de Feign
            String errorMessage = "Error al consumir la API: " + e.getMessage();
            System.out.println(errorMessage);
            return errorMessage;
        } catch (Exception e) {
            String errorMessage = "Error inesperado: " + e.getMessage();
            System.out.println(errorMessage);
            return errorMessage;
        }
    }
    
    // Método para parsear el JSON
    private String parseJsonForNombre(String json) {
        if (json != null && json.contains("nombre")) {
            String[] parts = json.split("\"nombre\":\"");
            if (parts.length > 1) {
                return parts[1].split("\"")[0];
            }
        }
        return "Nombre no encontrado";
    }
}



