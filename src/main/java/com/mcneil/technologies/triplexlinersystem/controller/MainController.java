package com.mcneil.technologies.triplexlinersystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(@RequestParam(name = "success", required = false) String param, Model model) {
        model.addAttribute("success", param);
        return "home";
    }
}
