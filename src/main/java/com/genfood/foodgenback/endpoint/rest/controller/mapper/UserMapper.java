package com.genfood.foodgenback.endpoint.rest.controller.mapper;


import com.genfood.foodgenback.endpoint.rest.controller.entity.UserEntity;
import com.genfood.foodgenback.model.User;
import com.genfood.foodgenback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final UserService userService;

    public User ToRestUser(UserEntity userEntity){
        User user = userService.getByMail(userEntity.getMail());
        return User.builder()
                .id(user.getId())
                .username(userEntity.getUsername())
                .firstname(userEntity.getFirstname())
                .lastname(userEntity.getLastname())
                .mail(userEntity.getMail())
                .password(userEntity.getPassword())
                .build();
    }
    public UserEntity ToDomainUser(User user){
        return UserEntity.builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .mail(user.getMail())
                .password(user.getPassword())
                .build();
    }
}
