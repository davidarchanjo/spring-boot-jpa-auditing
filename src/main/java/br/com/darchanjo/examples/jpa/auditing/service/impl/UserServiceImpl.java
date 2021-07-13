package br.com.darchanjo.examples.jpa.auditing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.darchanjo.examples.jpa.auditing.entity.User;
import br.com.darchanjo.examples.jpa.auditing.repository.UserRepository;
import br.com.darchanjo.examples.jpa.auditing.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(Optional<User> user) {
        return repository.save(user.get());
    }

    @Override
    public void update(Optional<User> user) {
        User source = user.get();
        User target = repository.findById(source.getUserId()).get();

        // createdBy and createdDate must be ignored so these informations can not be overriden after update
        BeanUtils.copyProperties(source, target, new String[] { "createdBy", "createdDate" });
        repository.save(target);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
