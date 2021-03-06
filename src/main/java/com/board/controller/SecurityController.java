package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @GetMapping("/page")
    public String page() throws Exception{
        return "/page";
    }

    @GetMapping("/user/page")
    public String userPage() throws Exception{
        return "/user/page";
    }

    @GetMapping("/member/page")
    public String memberPage() throws Exception{
        return "/member/page";
    }

    @GetMapping("/admin/page")
    public String adminPage() throws Exception{
        return "/admin/page";
    }

    @GetMapping("/secu/loginPage")
    public String loginPage() throws Exception{
        return "/secu/loginPage";
    }

    @GetMapping(value="/access_denied_page")
    public String accessDeniedPage() throws Exception {
        return "/access_denied_page";
    }

    @PostMapping (value="/logout")
    public String logout() throws Exception {
        return "/logout";
    }
}
