package com.Trt.file_transferMp4.Controller;

import ch.qos.logback.core.model.Model;
import com.Trt.file_transferMp4.Dto.AccesRequestDto;
import com.Trt.file_transferMp4.Dto.FileUploadLogDto;
import com.Trt.file_transferMp4.Entity.AccessRequest;
import com.Trt.file_transferMp4.Entity.FileUploadLog;
import com.Trt.file_transferMp4.Entity.User;
import com.Trt.file_transferMp4.service.AccessRequestService;
import com.Trt.file_transferMp4.service.impl.FileUploadLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FileUploadLogServiceImpl fileUploadLogService;

    // File logları görüntülemek için olan kısım
    @GetMapping("/logs")
    public ResponseEntity<List<FileUploadLogDto>> getAllLogs() {
        List<FileUploadLogDto> logs = fileUploadLogService.findAllLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/logs/user/{userId}")
    public ResponseEntity<List<FileUploadLogDto>> getLogsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<FileUploadLogDto> logs = fileUploadLogService.findLogsByUser(user);
        return ResponseEntity.ok(logs);
    }

    @DeleteMapping("/logs/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        fileUploadLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }

    // Erişim Taleplerini Listelemek için olan kısım
    @Autowired
    AccessRequestService accessRequestService;

    @GetMapping("/access-requests")
    public ResponseEntity<List<AccesRequestDto>> getAllAccessRequests() {
        List<AccesRequestDto> accessRequestDtos = accessRequestService.getAllAccessRequests();
        return ResponseEntity.ok(accessRequestDtos);
    }
}
