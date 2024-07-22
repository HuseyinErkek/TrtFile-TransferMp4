package com.Trt.file_transferMp4.mapper;

import com.Trt.file_transferMp4.Dto.ServerAccessDto;
import com.Trt.file_transferMp4.Entity.ServerAccess;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServerAccessMapper {
    ServerAccessMapper INSTANCE = Mappers.getMapper(ServerAccessMapper.class);

    ServerAccess serverAccessToServerAccess(ServerAccessDto serverAccessDto);

    List<ServerAccess> serverAccessToServerAccessList(List<ServerAccessDto> serverAccessDtoList);
}
