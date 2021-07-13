package br.com.darchanjo.examples.jpa.auditing.service;

import java.util.List;
import java.util.Optional;

import br.com.darchanjo.examples.jpa.auditing.entity.User;

public interface UserService {
    User create(Optional<User> user);

    void update(Optional<User> user);

    List<User> findAll();
}
