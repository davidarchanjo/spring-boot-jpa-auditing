package br.com.example.davidarchanjo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.davidarchanjo.builder.UserBuilder;
import br.com.example.davidarchanjo.exception.UserNotFoundException;
import br.com.example.davidarchanjo.model.dto.UserDTO;
import br.com.example.davidarchanjo.repository.UserRepository;
import br.com.example.davidarchanjo.service.UserService;
import lombok.val;
import lombok.var;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserBuilder userBuilder;

    @Override
    public Long create(UserDTO dto) {
        var user = userBuilder.build(dto);
        user = repository.save(user);
        return user.getUserId();
    }

    @Override
    public void update(Long userId, UserDTO dto) {
        val user = repository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
        BeanUtils.copyProperties(dto, user,  new String[] { "userId" });
        repository.save(user);
    }

    @Override
    public UserDTO findById(Long userId) {
        val user = repository.findById(userId)
            .map(userBuilder::build)
            .orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll()
            .stream()
            .map(userBuilder::build)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Long userId) {        
        val user = repository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
        repository.delete(user);
    }
}
