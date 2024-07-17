package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.Entity.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    List<AccessRequest> findByUserId(Long userId);
}
