package me.shinsunyoung.springbootdeveloper.domain.repository;

import me.shinsunyoung.springbootdeveloper.domain.service.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
