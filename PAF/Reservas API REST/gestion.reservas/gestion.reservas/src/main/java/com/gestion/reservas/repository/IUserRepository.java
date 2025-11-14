package com.gestion.reservas.repository;

import com.gestion.reservas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNick(String nick);
}
