package com.Trt.file_transferMp4.Dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class ServerAccessDto {

    private Long id;

    @NotNull(message = "Username cannot be null")
    private String username;

    private boolean approved;
}
