package com.Trt.file_transferMp4.repository;

import com.Trt.file_transferMp4.model.FileUploadLog;
import com.Trt.file_transferMp4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileUploadLogRepository extends JpaRepository<FileUploadLog, Long> {
    List<FileUploadLog> findByUser(User user);
}