package com.Trt.file_transferMp4.Controller;


import ch.qos.logback.core.model.Model;
import com.Trt.file_transferMp4.model.FileUploadLog;
import com.Trt.file_transferMp4.model.User;
import com.Trt.file_transferMp4.service.FileUploadLogService;
import com.Trt.file_transferMp4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
    public class FileUploadController {

        @Autowired
        private FileUploadLogService fileUploadLogService;

        @Autowired
        private UserService userService;

        @GetMapping("/upload")
        public String listUploadedFiles(Model model) throws IOException {
            return "uploadForm";
        }

        @PostMapping("/upload")
        public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                       RedirectAttributes redirectAttributes,
                                       Principal principal) {
            String username = principal.getName();
            User user = userService.findByUsername(username);

            // Dosya yükleme işlemini gerçekleştir
            FileUploadLog log = new FileUploadLog();
            log.setFileName(file.getOriginalFilename());
            log.setUploadTime(LocalDateTime.now());
            log.setUser(user);

            fileUploadLogService.saveLog(log);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

            return "redirect:/upload";
        }
    }

