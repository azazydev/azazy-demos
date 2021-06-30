package com.example.paginationdemo.service;

import com.example.paginationdemo.model.User;
import com.example.paginationdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    public Page<User> getPaginatedUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
