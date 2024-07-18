package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;

import java.util.List;

public interface AccessRequestService {
    AccessRequest createAccessRequest(AccesRequestDto accesRequestDto);
    List<AccesRequestDto> getAllAccessRequests();

}
