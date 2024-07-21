package com.Trt.file_transferMp4.Dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class ServerDto {

    private Long id;

    @NotNull(message = "Server name cannot be null")
    private String serverName;
}
