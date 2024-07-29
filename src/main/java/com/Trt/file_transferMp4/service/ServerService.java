package com.Trt.file_transferMp4.service;

import com.Trt.file_transferMp4.Entity.Server;

import java.util.List;
import java.util.Optional;

public interface ServerService {
    List<Server> getAllServers();
    //Optional<Server> getServerByName(String serverName);
    Server addServer(Server server);
    void deleteServerByName(String serverName);
    Server findByServerName(String serverName);
    //String getAdressByserverName(String serverName);


}
