package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
