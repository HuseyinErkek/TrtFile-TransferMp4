package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.repository.AccessRequestRepository;
import com.Trt.file_transferMp4.service.AccessRequestService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        AccessRequest accessRequest = modelMapper.map(accesRequestDto, AccessRequest.class);
        // Eğer kullanıcıyı ayarlamak gerekiyorsa, kullanıcıyı ayarla burada
        return accessRequestRepository.save(accessRequest);
    }

    @Override
    @Transactional
    public List<AccesRequestDto> getAllAccessRequests() {
        List<AccessRequest> accessRequests = accessRequestRepository.findAll();
        return accessRequests.stream()
                .map(accessRequest -> modelMapper.map(accessRequest, AccesRequestDto.class))
                .collect(Collectors.toList());
    }
}
