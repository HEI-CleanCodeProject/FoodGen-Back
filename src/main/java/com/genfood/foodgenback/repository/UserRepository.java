package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);

    User getById(Long id);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
