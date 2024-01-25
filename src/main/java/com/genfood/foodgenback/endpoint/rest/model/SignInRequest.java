package com.genfood.foodgenback.endpoint.rest.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SignInRequest implements Serializable {
    // TODO: Validation
    private String email;
    private String password;
}
