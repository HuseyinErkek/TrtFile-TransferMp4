package com.Trt.file_transferMp4.repository;



import com.Trt.file_transferMp4.Entity.ServerAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerAccessRepository extends JpaRepository<ServerAccess, Long> {
    List<ServerAccess> findByUsername(String username);
}

