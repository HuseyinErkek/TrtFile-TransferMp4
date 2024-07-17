package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.Rolee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Rolee, Long> {
    Rolee findByName(String name);
}
