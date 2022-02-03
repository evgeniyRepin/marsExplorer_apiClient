package com.evgeniy_repin.projects.marsexplorer.entities;

import java.util.List;

public class MarsExplorerApiResponse {

    List<MarsPhoto> photos;

    public List<MarsPhoto> getPhotos() {
        return photos;
    }
    public void setPhotos(List<MarsPhoto> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {

        return "MarsRoverApiResponse{" +
                "photos=" + photos +
                '}';
    }
}
