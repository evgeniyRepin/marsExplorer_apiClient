package com.evgeniy_repin.projects.marsexplorer.services;

import com.evgeniy_repin.projects.marsexplorer.ApiKey;
import com.evgeniy_repin.projects.marsexplorer.entities.MarsExplorerApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsExplorerApiService {

    public MarsExplorerApiResponse getExplorerData(String explorerType) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MarsExplorerApiResponse> responseEntity = restTemplate.getForEntity(
                "https://api.nasa.gov/mars-photos/api/v1/rovers/" +
                        explorerType +
                        "/photos?sol=2" +
                        "&api_key=" + ApiKey.API_KEY.getKey()
                , MarsExplorerApiResponse.class);

        return responseEntity.getBody();
    }
}
