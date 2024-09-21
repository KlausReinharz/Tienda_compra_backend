package com.klaus.ecommerBack.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private  String username;
    private String password;

}

/*
* LAS CLASESE DTO (DATA TRANSFER OBJECT) SIRVE PARA
* LA TRANSFERENCIA DE DATOS ENTRE LA DIFERENTES CAPAS
* COMO CONTROLADOR Y SERVICIOS
* */