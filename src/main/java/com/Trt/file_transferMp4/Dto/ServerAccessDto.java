package com.Trt.file_transferMp4.Dto;

import com.Trt.file_transferMp4.Entity.User;
import lombok.Data;

@Data
public class ServerAccessDto {
    private Long id;

    private String username;

    private boolean approved;
}
