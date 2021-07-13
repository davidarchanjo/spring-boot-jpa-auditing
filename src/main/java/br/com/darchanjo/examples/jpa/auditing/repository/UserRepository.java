package br.com.darchanjo.examples.jpa.auditing.repository;

import br.com.darchanjo.examples.jpa.auditing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
