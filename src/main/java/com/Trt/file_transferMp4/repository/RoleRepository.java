package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUsername(String username);
}
