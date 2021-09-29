package com.board.controller;

import com.board.domain.AuthInfo;
import com.board.domain.LoginCommand;
import com.board.exception.IdPasswordNotMatchingException;
import com.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView loginForm(LoginCommand loginCommand,
                                  @CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) throws Exception {

        if (rememberCookie != null) {
            loginCommand.setId(rememberCookie.getValue());
            loginCommand.setRememberId(true);
        }

        ModelAndView mv = new ModelAndView("/login/loginForm");
        return mv;
    }

    @Resource(name="userService")
    private UserService userSer;

    @PostMapping("/login")
    public ModelAndView loginSuccess(@Valid LoginCommand loginCommand, BindingResult bindingResult,
                                     HttpSession session, HttpServletResponse response) throws Exception {

        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("/login/loginForm");
            return mv;
        }

        try {

            AuthInfo authInfo = userSer.loginAuth(loginCommand);
            session.setAttribute("authInfo", authInfo);

            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
            rememberCookie.setPath("/");
            if(loginCommand.isRememberId()) {
                rememberCookie.setMaxAge(60*60*24*7);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);

        } catch (IdPasswordNotMatchingException e) {
            bindingResult.rejectValue("pw", "notMatch", "아이디와 비밀번호가 맞지않습니다.");
            ModelAndView mv = new ModelAndView("/login/loginForm");
            return mv;
        }

        ModelAndView mv = new ModelAndView("/login/loginSuccess");
        return mv;


    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
}
