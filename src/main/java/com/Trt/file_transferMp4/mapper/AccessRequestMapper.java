package com.Trt.file_transferMp4.mapper;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccessRequestMapper {
    //FACTORY pattern
    // Instance singleton
    static AccessRequestMapper INSTANCE = Mappers.getMapper(AccessRequestMapper.class);

    AccessRequest toAccessRequest(AccesRequestDto serverAccessDto);

    List<AccesRequestDto> toServerAccessDtoList(List<AccessRequest> serverAccessDto);

    AccesRequestDto toServerAccessDto(AccessRequest accessRequest);

}
