package com.genfood.foodgenback.endpoint.rest.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SignUpRequest implements Serializable {
    private String username;
    // TODO: validation
    private String email;
    private String password;
}
