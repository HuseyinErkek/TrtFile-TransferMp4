package com.Trt.file_transferMp4.repository;


import com.Trt.file_transferMp4.Entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Optional<Server> findByServerName(String serverName);
    void deleteByServerName(String serverName);
}

