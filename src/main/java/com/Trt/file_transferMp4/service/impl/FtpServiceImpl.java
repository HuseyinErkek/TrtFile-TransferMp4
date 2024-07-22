package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Entity.Server;
import com.Trt.file_transferMp4.repository.ServerRepository;
import com.Trt.file_transferMp4.service.FileUploadLogService;
import com.Trt.file_transferMp4.service.FtpService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FtpServiceImpl implements FtpService {

    private static final Logger logger = LoggerFactory.getLogger(FtpServiceImpl.class);

    private final FileUploadLogService fileUploadLogService;
    private final ServerRepository serverRepository;

    @Override
    public Boolean sendFile(byte[] file, String filePath, String username) {
        FTPClient ftpClient = new FTPClient();
        InputStream targetStream = new ByteArrayInputStream(file);

        try {
            // Sunucu adını veritabanından al
            Server server = serverRepository.findByServerName("serverName")
                    .orElseThrow(() -> new RuntimeException("Server not found"));

            String ipAddress = server.getIpAdress(); // IP adresini al
            int port = server.getPort();
            String serverPassword = server.getServerPassword();
            String serverUsername = server.getServerUsername();

            // FTP bağlantısını kur
            ftpClient.connect(ipAddress, port);
            ftpClient.login(serverUsername, serverPassword);
            boolean done = ftpClient.storeFile(filePath, targetStream);

            if (done) {
                // Dosya yükleme başarılıysa log oluştur
                FileUploadLogDto fileUploadLogDto = new FileUploadLogDto();
                fileUploadLogDto.setUserName(username);
              //  fileUploadLogDto.setFileName(fileName);
                fileUploadLogDto.setFilePath(filePath);
                fileUploadLogDto.setTransferTime(LocalDateTime.now());
                fileUploadLogService.saveLog(fileUploadLogDto);
            }

            ftpClient.logout();
            return done;
        } catch (Exception e) {
            logger.error("File upload failed: {}", e.getMessage(), e);
            return Boolean.FALSE;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }
            } catch (Exception ex) {
                logger.error("Failed to disconnect FTP client: {}", ex.getMessage(), ex);
            }
        }
    }
}
