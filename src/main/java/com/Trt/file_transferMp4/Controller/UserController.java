package com.Trt.file_transferMp4.Controller;


import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.Entity.Server;
import com.Trt.file_transferMp4.repository.AccessRequestRepository;
import com.Trt.file_transferMp4.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private AccessRequestRepository accessRequestRepository;

    @GetMapping("/request-access")
    public String requestAccessPage(Model model) {
        List<Server> servers = serverRepository.findAll();
        model.addAttribute("servers", servers);
        return "request-access";
    }

}
