package com.evgeniy_repin.projects.marsexplorer.controllers;


import com.evgeniy_repin.projects.marsexplorer.entities.MarsExplorerApiResponse;
import com.evgeniy_repin.projects.marsexplorer.services.MarsExplorerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    MarsExplorerApiService marsExplorerApiService;

    @GetMapping("/")
    public String getHomeView(Model model) {
        MarsExplorerApiResponse marsExplorerApiResponse = marsExplorerApiService.getExplorerData("spirit");
        model.addAttribute("explorerData", marsExplorerApiResponse);
        return "home_view";
    }

    @Autowired
    public void setMarsExplorerApiService(MarsExplorerApiService marsExplorerApiService) {
        this.marsExplorerApiService = marsExplorerApiService;
    }

    public MarsExplorerApiService getMarsExplorerApiService() {
        return marsExplorerApiService;
    }
}
