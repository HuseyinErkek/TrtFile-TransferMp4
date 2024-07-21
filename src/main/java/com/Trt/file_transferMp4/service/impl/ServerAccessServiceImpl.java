package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Dto.ServerAccessDto;
import com.Trt.file_transferMp4.Entity.ServerAccess;
import com.Trt.file_transferMp4.repository.ServerAccessRepository;
import com.Trt.file_transferMp4.service.ServisAccessService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServerAccessServiceImpl implements ServisAccessService {

    @Autowired
    private ServerAccessRepository serverAccessRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<ServerAccessDto> getAllServerAccesses() {
        List<ServerAccess> accesses = serverAccessRepository.findAll();
        return accesses.stream()
                .map(access -> modelMapper.map(access, ServerAccessDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ServerAccessDto> getServerAccessesByUserId(String username) {
        List<ServerAccess> accesses = serverAccessRepository.findByUsername(username);
        return accesses.stream()
                .map(access -> modelMapper.map(access, ServerAccessDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateServerAccess(String username, boolean approved) {
        List<ServerAccess> accesses = serverAccessRepository.findByUsername(username);
        if (accesses.isEmpty()) {
            throw new IllegalArgumentException("Erişim bulunamadı.");
        }
        for (ServerAccess access : accesses) {
            access.setApproved(approved);
            serverAccessRepository.save(access);
        }
    }

    @Override
    @Transactional
    public void deleteServerAccessByUsername(String username) {
        List<ServerAccess> accesses = serverAccessRepository.findByUsername(username);
        if (accesses.isEmpty()) {
            throw new IllegalArgumentException("Erişim bulunamadı.");
        }
        serverAccessRepository.deleteAll(accesses);
    }
}
