package com.codegym.login.controller;

import com.codegym.login.request.Credential;
import com.codegym.login.response.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("credential", new Credential());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView showGreeting(@ModelAttribute("credential") Credential credential) {
        User user = new User();
        user.setUserName(credential.getUsername());
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
