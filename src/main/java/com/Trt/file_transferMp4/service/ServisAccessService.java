package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Dto.ServerAccessDto;

import java.util.List;

public interface ServisAccessService {
    List<ServerAccessDto> getAllServerAccesses();
    List<ServerAccessDto> getServerAccessesByUserId(String username);
    void updateServerAccess(String Username, boolean approved);
    void deleteServerAccessByUsername(String username);

}
