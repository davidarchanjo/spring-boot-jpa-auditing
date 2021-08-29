package br.com.example.davidarchanjo.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.example.davidarchanjo.exception.UserNotFoundException;
import br.com.example.davidarchanjo.model.dto.UserDTO;
import br.com.example.davidarchanjo.service.UserService;
import lombok.val;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(
        @Valid @RequestBody UserDTO dto,
        UriComponentsBuilder uriComponentsBuilder
    ) {
        val userId = userService.create(dto);
        val uriComponents = uriComponentsBuilder
            .path("/users/{id}")
            .buildAndExpand(userId);

        val headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .headers(headers)
            .build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> find(@PathVariable Long userId) {
        val body = userService.findById(userId);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        val body = userService.findAll();        
        return body.isEmpty() 
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(body);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(
        @Valid @RequestBody UserDTO dto,
        @PathVariable Long userId
    ) {
        userService.update(userId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<?> handlerUserNotFoundException() {
        val body = new HashMap<>();
        body.put("message", "User not found");
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)   
            .body(body);
    }
}
