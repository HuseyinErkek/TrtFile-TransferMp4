package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.model.User;
import com.Trt.file_transferMp4.repository.RoleRepository;
import com.Trt.file_transferMp4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Diğer servis metodları
}

