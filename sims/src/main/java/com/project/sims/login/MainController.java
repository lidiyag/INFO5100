package com.project.sims.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/admin/login")
    public String viewAdminLoginPage(){
        return "admin/admin_login";
    }

    @GetMapping("/student/login")
    public String viewUserLoginPage(){
        return "student/student_login";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(){
        return "admin/admin_home";
    }

    @GetMapping("/student/home")
    public String viewUserHomePage(){
        return "student/student_home";
    }

}
