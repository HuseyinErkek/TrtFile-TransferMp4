package com.Trt.file_transferMp4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    //URL'de home ekini girip yakalar.
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user";
    }
    /*
    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }*/
}
