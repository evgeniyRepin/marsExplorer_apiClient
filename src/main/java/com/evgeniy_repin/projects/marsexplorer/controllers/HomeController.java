package com.evgeniy_repin.projects.marsexplorer.controllers;


import com.evgeniy_repin.projects.marsexplorer.DTOs.HomeDto;
import com.evgeniy_repin.projects.marsexplorer.entities.MarsExplorerApiResponse;
import com.evgeniy_repin.projects.marsexplorer.services.MarsExplorerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Random;

@Controller
public class HomeController {

    MarsExplorerApiService marsExplorerApiService;

    @GetMapping("/")
    public String getHomeView(@ModelAttribute HomeDto homeDto, ModelMap model) {
        if (StringUtils.isEmpty(homeDto.getMarsExplorerName())) {
            homeDto.setMarsExplorerName("Opportunity");
        }
        if (homeDto.getSol() == null) {
//            homeDto.setSol(new Random().nextInt(1000));
            homeDto.setSol(2);
        }

        MarsExplorerApiResponse marsExplorerApiResponse = marsExplorerApiService.getExplorerData(homeDto);
        model.put("explorerData", marsExplorerApiResponse);
        model.put("homeDto", homeDto);
        model.put("validCameras", marsExplorerApiService.getValidCameras().get(homeDto.getMarsExplorerName()));
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
