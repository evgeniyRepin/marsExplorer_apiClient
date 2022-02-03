package com.evgeniy_repin.projects.marsexplorer.services;

import com.evgeniy_repin.projects.marsexplorer.ApiKey;
import com.evgeniy_repin.projects.marsexplorer.DTOs.HomeDto;
import com.evgeniy_repin.projects.marsexplorer.entities.MarsExplorerApiResponse;
import com.evgeniy_repin.projects.marsexplorer.entities.MarsPhoto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


//TODO create an interface for this service
@Service
public class MarsExplorerApiService {

    private Map<String, List<String>> validCameras = new HashMap<>();

    public MarsExplorerApiService() {
        validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
        validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
    }

    public MarsExplorerApiResponse getExplorerData(HomeDto homeDto) {
        RestTemplate restTemplate = new RestTemplate();

        List<String> urlEndpoints = getUrlEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsExplorerApiResponse marsExplorerApiResponse = new MarsExplorerApiResponse();

        urlEndpoints.stream()
                .forEach(url -> {
                    MarsExplorerApiResponse response
                            = restTemplate.getForObject(url, MarsExplorerApiResponse.class);
                    photos.addAll(response.getPhotos());
                });
        marsExplorerApiResponse.setPhotos(photos);

        return marsExplorerApiResponse;

//        ResponseEntity<MarsExplorerApiResponse> responseEntity = restTemplate.getForEntity(
//                "https://api.nasa.gov/mars-photos/api/v1/rovers/" +
//                        homeDto.getMarsExplorerName() +
//                        "/photos?sol=" + homeDto.getSol() +
//                        "&api_key=" + ApiKey.API_KEY.getKey()
//                , MarsExplorerApiResponse.class);

    }

    public List<String> getUrlEndpoints(HomeDto homeDto) {
        List<String> urls = new ArrayList<>();
        List<String> validCamerasForThisRover = validCameras.get(homeDto.getMarsExplorerName());

        Method[] methods = homeDto.getClass().getMethods();
//        TODO make it more readable
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("getCamera") && Boolean.TRUE.equals(method.invoke(homeDto))) {
                    String cameraName = method.getName().split("getCamera")[1];
                    if (validCamerasForThisRover.contains(cameraName)) {
                        urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" +
                                homeDto.getMarsExplorerName() +
                                "/photos?sol=" + homeDto.getSol() +
                                "&api_key=" + ApiKey.API_KEY.getKey() +
                                "&camera=" + cameraName);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return urls;
    }

    public Map<String, List<String>> getValidCameras() {
        return validCameras;
    }
    public void setValidCameras(Map<String, List<String>> validCameras) {
        this.validCameras = validCameras;
    }
}
