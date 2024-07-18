package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);
}
