package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Entity.Server;

public interface FtpService {

    Boolean sendFile(byte[] file, String filePath, String username);
}
