package com.genfood.foodgenback.service;


import com.genfood.foodgenback.model.User;
import com.genfood.foodgenback.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;

    public User getUserByName(String userName){
        return repository.findByUsername(userName);
    }

    // public User getByUserId(Long id){
    //    return repository.getById(id);
    // }
    public User saveUser(User user){
        return repository.save(user);
    }
    public User getUserByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

}
