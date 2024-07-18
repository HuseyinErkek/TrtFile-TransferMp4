package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.repository.RoleRepository;
import com.Trt.file_transferMp4.repository.UserRepository;
import com.Trt.file_transferMp4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return null;
        //return userRepository.findByUsername(username);
    }

    // Diğer servis metodları
}
