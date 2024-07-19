package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Entity.FileUploadLog;
import com.Trt.file_transferMp4.repository.FileUploadLogRepository;
import com.Trt.file_transferMp4.service.FileUploadLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileUploadLogServiceImpl implements FileUploadLogService {

    @Autowired
    private FileUploadLogRepository fileUploadLogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveLog(FileUploadLogDto logDto) {
        FileUploadLog log = modelMapper.map(logDto, FileUploadLog.class);
        fileUploadLogRepository.save(log);
    }

    @Override
    public List<FileUploadLogDto> findLogsByUser(com.Trt.file_transferMp4.Entity.User user) {
        List<FileUploadLog> logs = fileUploadLogRepository.findByUser(user);
        return logs.stream()
                .map(log -> modelMapper.map(log, FileUploadLogDto.class))
                .collect(Collectors.toList());
    }



    @Override
    public List<FileUploadLogDto> findAllLogs() {
        List<FileUploadLog> logs = fileUploadLogRepository.findAll();
        return logs.stream()
                .map(log -> modelMapper.map(log, FileUploadLogDto.class))
                .collect(Collectors.toList());    }

    @Override
    public void deleteLog(Long id) {
        fileUploadLogRepository.deleteById(id);
    }

    // Diğer servis metodları
}
