package br.com.darchanjo.examples.jpa.auditing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.darchanjo.examples.jpa.auditing.entity.User;
import br.com.darchanjo.examples.jpa.auditing.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * NOTE: Ideally it should be exposd a DTO or VO object for data transfer. NOTE:
     * Ideally it Exception handling should be implemented from a global hander by
     * levearing @ControllerAdvice
     */
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody Optional<User> user) {
        return userService.create(user);
    }

    @PutMapping
    public void updateUser(@RequestBody Optional<User> user) {
        userService.update(user);
    }
}
