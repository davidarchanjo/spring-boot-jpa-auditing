package br.com.example.davidarchanjo.service;

import java.util.List;

import br.com.example.davidarchanjo.model.dto.UserDTO;

public interface UserService {

    Long create(UserDTO dto);
    UserDTO findById(Long userId);
    List<UserDTO> findAll();
    void update(Long userId, UserDTO dto);
    void delete(Long userId);
}
