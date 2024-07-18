package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
        List<AccessRequest> findAll();
        //List<AccessRequest> findByUserId(Long userId);

   // AccessRequest findByUsername(String username);
}
