package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Entity.FileUploadLog;
import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.repository.FileUploadLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadLogService {

    @Autowired
    private FileUploadLogRepository fileUploadLogRepository;

    public void saveLog(FileUploadLog log) {
        fileUploadLogRepository.save(log);
    }

    public List<FileUploadLog> findLogsByUser(User user) {
        return null;
        //return fileUploadLogRepository.findByUser(user);
    }

    public List<FileUploadLog> findAllLogs() {
        return fileUploadLogRepository.findAll();
    }

    // Diğer servis metodları
}
