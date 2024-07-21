package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.repository.UserRepository;
import com.Trt.file_transferMp4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
