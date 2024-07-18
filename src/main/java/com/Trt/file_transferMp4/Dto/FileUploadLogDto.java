package com.Trt.file_transferMp4.Dto;

import lombok.Data;

@Data
public class FileUploadLogDto {

    private Long id;

    private String userName;

    private String fileName;

    private String transferTime;

    private String filePath;
}
