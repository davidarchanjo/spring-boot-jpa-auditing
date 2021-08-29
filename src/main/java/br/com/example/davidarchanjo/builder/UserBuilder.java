package br.com.example.davidarchanjo.builder;

import org.springframework.stereotype.Component;

import br.com.example.davidarchanjo.model.domain.User;
import br.com.example.davidarchanjo.model.dto.UserDTO;

@Component
public class UserBuilder {
    
    public User build(UserDTO obj) {
        User user = new User();
        user.setUserId(obj.getUserId());
        user.setFirstName(obj.getFirstName());
        user.setLastName(obj.getLastName());
        user.setEmail(obj.getEmail());
        return user;
    }

    public UserDTO build(User obj) {
        return UserDTO.builder()
            .userId(obj.getUserId())
            .firstName(obj.getFirstName())
            .lastName(obj.getLastName())
            .email(obj.getEmail())
            .build();
    }
}