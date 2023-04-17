package com.example.alpha_test.api.service;

import com.example.alpha_test.model.User;
import com.example.alpha_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User getById(Integer userId) {
        return this.userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }
    public User saveOrUpdate(final User user) {
        return this.userRepository.save(user);
    }

    public boolean delete(Integer userId) {
        try {
            this.userRepository.deleteById(userId);
        } catch (Exception ex) {
            return false;
        }
        return  true;
    }
}
