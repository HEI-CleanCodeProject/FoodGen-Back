package com.genfood.foodgenback.repository;

import com.genfood.foodgenback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);

    User getById(Long id);
    User findByMail(String mail);

    boolean existsByMail(String mail);
}
