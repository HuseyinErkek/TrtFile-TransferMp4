package com.Trt.file_transferMp4.Dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class FileUploadLogDto {

    private Long id;

    @NotNull(message = "User name cannot be null")
    private String userName;

    @NotNull(message = "File name cannot be null")
    private String fileName;


    private LocalDateTime transferTime;

    @NotNull(message = "File path cannot be null")
    private String filePath;
}
