package com.Trt.file_transferMp4.Dto;

import com.Trt.file_transferMp4.Entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private LocalDateTime acces_time;

    private List<RoleDto> role;

}
