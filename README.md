# Proyecto API Consumir

Este proyecto es una aplicación Spring Boot que consume una API externa usando OpenFeign. La aplicación está diseñada para consultar un endpoint específico y manejar diferentes códigos de respuesta HTTP, extrayendo información de la respuesta JSON cuando es necesario.

## Requisitos

- JDK 21
- Maven

## Descripción
La aplicación tiene como objetivo consumir un endpoint de API externa y manejar la respuesta basada en el código de estado HTTP recibido:

Código 302: Extrae e imprime el valor del campo nombre de la respuesta JSON.
Código 404: Imprime "Sin resultados."

## Estructura del Proyecto
Dependencias
El proyecto utiliza las siguientes dependencias:

- spring-boot-starter-web: Para las funcionalidades básicas de Spring Boot y soporte de RESTful.
- spring-cloud-starter-openfeign: Para la integración con OpenFeign, permitiendo la comunicación con servicios externos.

## Estructura de Clases
- ApiClient: Interfaz que define el cliente Feign para consumir el endpoint de la API externa.
- ApiService: Servicio que maneja la lógica de consumo de la API y procesamiento de la respuesta.
- ApiController: Controlador REST que expone un endpoint para consumir la API externa.
- ApiResponse: Modelo de datos para representar la estructura de la respuesta JSON de la API externa.

## Imagen de Ejemplo en Postman
![Ejemplo prueba en postman](images/example.png)

