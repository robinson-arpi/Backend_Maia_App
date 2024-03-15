package com.maia.maia_app.authentication.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.maia.maia_app.authentication.User.Role;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}