package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {// it receives the name of the class and the id tye
   Optional<User> findUserByDocument(String document); // Here I created a method that gonna search the users by their documents

    Optional<User> findUserById(Long id);
}
