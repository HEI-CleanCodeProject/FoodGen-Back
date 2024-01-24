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
    private final UserRepository userRepository;

    public User getUserByName(String userName){
        return userRepository.findByUsername(userName);
    }
    public User getByUserId(Long id){
        return userRepository.getById(id);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User getByMail(String mail){
        return userRepository.findByMail(mail);
    }

}
