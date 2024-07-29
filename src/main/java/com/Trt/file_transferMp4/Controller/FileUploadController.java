package com.Trt.file_transferMp4.Controller;

import com.Trt.file_transferMp4.service.FtpService;
import com.Trt.file_transferMp4.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FtpService ftpService;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("username") String username,
                                        @RequestParam("folder") String serverName,
                                        @RequestParam("file") MultipartFile file) {
        try {
            // Dosya adı ve yolunu belirle
            String fileName = file.getOriginalFilename();
            String filePath = serverName + "/" + fileName;

            // Dosyayı yükle
            byte[] fileBytes = file.getBytes();
            boolean result = ftpService.sendFile(fileBytes, filePath,username);

            if (result) {
                return ResponseEntity.ok().body("{\"success\": true}");
            } else {
                return ResponseEntity.status(500).body("{\"success\": false}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
        }
    }
    private ServerService serverService;
    @GetMapping("/getServerAddressByFolder")
    public String getServerAddressByFolder(@RequestParam String folder) {
        return ftpService.getAddressByFolder(folder);
    }
}
