package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.repository.AccessRequestRepository;
import com.Trt.file_transferMp4.service.AccessRequestService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessRequestServiceImpl implements AccessRequestService {
    @Autowired
    private AccessRequestRepository accessRequestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AccessRequest createAccessRequest(AccesRequestDto accesRequestDto) {
        AccessRequest accessRequest = new AccessRequest();
        accessRequest.setUserName(accesRequestDto.getUserName());
        accessRequest.setUnit(accesRequestDto.getUnit());
        accessRequest.setUnitTitle(accesRequestDto.getUnitTitle());
        accessRequest.setServerName(accesRequestDto.getServerName());
        //USER ayarlamamiz gerekir mi?
        //Userden id alıyor ama dto da yok .
        return accessRequestRepository.save(accessRequest);
    }

    @Override
    @Transactional
    public List<AccesRequestDto> getAllAccessRequests() {
        //Model mapper kullanimi
        List<AccessRequest> accessRequests = accessRequestRepository.findAll();
        return accessRequests.stream()
                .map(accessRequest -> modelMapper.map(accessRequest, AccesRequestDto.class))
                .collect(Collectors.toList());
    }
}
