package com.evgeniy_repin.projects.marsexplorer.controllers;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Cacheable("!div")
    @GetMapping("/")
    public String getHomeView(Model model) {
        model.addAttribute("name", "Eugene");
        return "home_view";
    }
}
