package br.com.example.davidarchanjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.davidarchanjo.model.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
