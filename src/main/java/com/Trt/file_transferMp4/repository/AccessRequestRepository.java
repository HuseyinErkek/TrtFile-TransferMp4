package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
        // JpaRepository zaten findAll() metodunu sağlar,

}
