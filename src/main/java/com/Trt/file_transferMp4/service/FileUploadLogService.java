package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Entity.User;

import java.util.List;

public interface FileUploadLogService {
    void saveLog(FileUploadLogDto logDto);
    List<FileUploadLogDto> findLogsByUser(User user);
    List<FileUploadLogDto> findAllLogs();
    void deleteLogByUsername(String username);  // Güncellenmiş metod adı

}
