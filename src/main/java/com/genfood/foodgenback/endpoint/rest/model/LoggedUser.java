package com.genfood.foodgenback.endpoint.rest.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class LoggedUser implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String role;
    private String token;
}
