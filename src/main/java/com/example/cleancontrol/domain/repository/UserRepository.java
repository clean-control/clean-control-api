package com.example.cleancontrol.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancontrol.domain.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByNickname(String nickname);

    Optional<Users> findByEmailAndPassword(String email, String password);

    Optional<Users> findByEmailAndNickname(String email, String nickname);

    Optional<Users> findByEmail(String email);

}
