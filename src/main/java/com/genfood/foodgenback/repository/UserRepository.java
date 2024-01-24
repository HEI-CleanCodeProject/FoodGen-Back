package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String name);

    User getById(String id);


}
