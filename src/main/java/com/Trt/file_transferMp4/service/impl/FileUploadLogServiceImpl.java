package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Entity.FileUploadLog;
import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.repository.FileUploadLogRepository;
import com.Trt.file_transferMp4.repository.UserRepository;
import com.Trt.file_transferMp4.service.FileUploadLogService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileUploadLogServiceImpl implements FileUploadLogService {

    private final FileUploadLogRepository fileUploadLogRepository;

    private final ModelMapper modelMapper;

    @Override
    public void saveLog(FileUploadLogDto logDto) {
        FileUploadLog log = modelMapper.map(logDto, FileUploadLog.class);
        fileUploadLogRepository.save(log);
    }

    @Override
    public List<FileUploadLogDto> findLogsByUser(User user) {
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
                .collect(Collectors.toList());
    }


    private final UserRepository userRepository;

    @Override
    @Transactional
    public void deleteLogByUsername(String username) {
        // UserRepository kullanarak gerçek User nesnesini bulma
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }

        // Kullanıcıya ait logları bulma
        List<FileUploadLog> logs = fileUploadLogRepository.findByUser(user);
        if (logs.isEmpty()) {
            throw new IllegalArgumentException("Kullanıcıya ait log bulunamadı.");
        }

        // Kullanıcıya ait tüm logları silme
        fileUploadLogRepository.deleteAll(logs);
    }



}
