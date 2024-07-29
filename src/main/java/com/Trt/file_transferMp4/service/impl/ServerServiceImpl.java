package com.Trt.file_transferMp4.service.impl;

import com.Trt.file_transferMp4.Entity.Server;
import com.Trt.file_transferMp4.repository.ServerRepository;
import com.Trt.file_transferMp4.service.ServerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    @Transactional
    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

//    @Override
//    @Transactional
//    public Optional<Server> getServerByName(String serverName) {
//        return serverRepository.findByServerName(serverName);
//    }

    @Override
    @Transactional
    public Server addServer(Server server) {
        if (serverRepository.findByServerName(server.getServerName()).isPresent()) {
            throw new IllegalArgumentException("Sunucu zaten mevcut.");
        }
        return serverRepository.save(server);
    }

    @Override
    @Transactional
    public void deleteServerByName(String serverName) {
        if (serverRepository.findByServerName(serverName).isEmpty()) {
            throw new IllegalArgumentException("Sunucu bulunamadı.");
        }
        serverRepository.deleteByServerName(serverName);
    }

    @Override
    public Server findByServerName(String serverName) {
        if (serverRepository.findByServerName(serverName).isEmpty()) {
            throw new IllegalArgumentException("Sunucu bulunamadı.");
        }
        return serverRepository.findByServerName(serverName).get();
    }


    //    @Override
//    public Server getServerByServerName(String serverName) {
//        if (serverRepository.findByServerName(serverName).isEmpty()) {
//            throw new IllegalArgumentException("Sunucu bulunamadı.");
//        }
//        return serverRepository.findByServerName(serverName).get();
//    }
}
