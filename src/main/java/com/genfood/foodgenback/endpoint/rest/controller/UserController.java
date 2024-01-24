package com.genfood.foodgenback.endpoint.rest.controller;

import com.genfood.foodgenback.endpoint.rest.controller.entity.UserEntity;
import com.genfood.foodgenback.endpoint.rest.controller.mapper.UserMapper;
import com.genfood.foodgenback.model.User;
import com.genfood.foodgenback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    @PutMapping("/user")
    public User Save(@RequestBody UserEntity userEntity){
        return userService.saveUser(userMapper.ToRestUser(userEntity));
    }

    @GetMapping("/user/{username}")
    public User getUserByUserName(@RequestParam String name){
        return userService.getUserByName(name);
    }
}
