package com.Trt.file_transferMp4.Dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AccesRequestDto {

    @NotNull(message = "User name cannot be null")
    private String userName;

    @NotNull(message = "Unit cannot be null")
    private String unit;

    @NotNull(message = "Unit title cannot be null")
    private String unitTitle;

    @NotNull(message = "Server name cannot be null")
    private String serverName;
}
