package com.Trt.file_transferMp4.Controller;

import ch.qos.logback.core.model.Model;
import com.Trt.file_transferMp4.model.FileUploadLog;
import com.Trt.file_transferMp4.service.FileUploadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FileUploadLogService fileUploadLogService;

    @GetMapping("/logs")
    public String showLogs(Model model) {
        List<FileUploadLog> logs = fileUploadLogService.findAllLogs();
        model.addText("logs");
        return "logView";
    }
}

