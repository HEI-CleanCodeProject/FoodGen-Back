package com.genfood.foodgenback.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PingController {

  @GetMapping("/ping")
  public String HealthController() {
    return "Hello world";
  }
}
