package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> getAllUsers();
}
