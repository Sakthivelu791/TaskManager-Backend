package com.sakthi.dev.TaskManager.Repository;

import com.sakthi.dev.TaskManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
