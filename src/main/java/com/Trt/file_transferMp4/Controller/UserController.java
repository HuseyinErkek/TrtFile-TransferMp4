package com.Trt.file_transferMp4.Controller;


import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.Entity.Server;
import com.Trt.file_transferMp4.repository.AccessRequestRepository;
import com.Trt.file_transferMp4.repository.ServerRepository;
import com.Trt.file_transferMp4.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
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
    //*************************************************
    //Kayıt talep etmek için oluşturuldu.
    @Autowired
    AccessRequestService accessRequestService;
    @PostMapping("/access-requests")
    public ResponseEntity<AccessRequest> createAccessRequest(@RequestBody AccesRequestDto accessRequestDto) {
        AccessRequest accessRequest = accessRequestService.createAccessRequest(accessRequestDto);
        // Burada admin'e bildirim göndermek için gerekli işlemleri yapabilirsiniz.
        return ResponseEntity.ok(accessRequest);
    }

}
