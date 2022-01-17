package com.evgeniy_repin.projects.marsexplorer.controllers;


import com.evgeniy_repin.projects.marsexplorer.entities.MarsExplorerApiResponse;
import com.evgeniy_repin.projects.marsexplorer.services.MarsExplorerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    MarsExplorerApiService marsExplorerApiService;

    @GetMapping("/")
    public String getHomeView(@RequestParam(required = false) String marsApiExplorerData
            , @RequestParam(required = false) Integer sol
            , @RequestParam(required = false) Boolean checkbox1
            , Model model) {
        if (StringUtils.isEmpty(marsApiExplorerData)) {
            marsApiExplorerData = "opportunity";
        }
        if (sol == null) {
            sol = 1;
        }
        MarsExplorerApiResponse marsExplorerApiResponse = marsExplorerApiService.getExplorerData(marsApiExplorerData, sol);
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
