package com.Trt.file_transferMp4.Controller;

import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AccessRequestController {
    @Autowired
    AccessRequestService accessRequestService;

    @PostMapping
    public ResponseEntity<AccessRequest> createAccessRequest(@RequestBody AccesRequestDto accessRequestDto) {
        AccessRequest accessRequest = accessRequestService.createAccessRequest(accessRequestDto);
        // Burada admin'e bildirim göndermek için gerekli işlemleri yapabilirsiniz.
        return ResponseEntity.ok(accessRequest);
    }

    @GetMapping
    public ResponseEntity<List<AccesRequestDto>> getAllAccessRequests() {
        List<AccesRequestDto> accessRequestDtos = accessRequestService.getAllAccessRequests();
        return ResponseEntity.ok(accessRequestDtos);
    }
}
