package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.mapper.AccessRequestMapper;
import com.Trt.file_transferMp4.repository.AccessRequestRepository;
import com.Trt.file_transferMp4.service.AccessRequestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRequestRepository accessRequestRepository;



    @Override
    @Transactional
    public AccessRequest createAccessRequest(AccesRequestDto accesRequestDto) {

        AccessRequest accessRequest = AccessRequestMapper.INSTANCE.toAccessRequest(accesRequestDto);


        // Eğer kullanıcıyı ayarlamak gerekiyorsa, kullanıcıyı ayarla burada
        return accessRequestRepository.save(accessRequest);
    }

    @Override
    @Transactional
    public List<AccesRequestDto> getAllAccessRequests() {
        List<AccessRequest> accessRequests = accessRequestRepository.findAll();
        return AccessRequestMapper.INSTANCE.toServerAccessDtoList(accessRequests);
    }
}
