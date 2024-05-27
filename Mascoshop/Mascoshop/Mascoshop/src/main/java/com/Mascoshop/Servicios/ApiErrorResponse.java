package com.Mascoshop.Servicios;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorResponse {

    private int code;
    private String message;

}
