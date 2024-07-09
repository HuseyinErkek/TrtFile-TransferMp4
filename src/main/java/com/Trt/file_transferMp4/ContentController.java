package com.Trt.file_transferMp4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    //URL'de home ekini girip yakalar.
    @GetMapping("/home")
    public String handleHome() {
        return "home";
    }
    @GetMapping("/admin/home")
    public String handleAdminHome(){
        return "home_admin";
    }
    @GetMapping("/admin/user")
    public String handleHomeUser(){
        return "home_user";
    }
}
