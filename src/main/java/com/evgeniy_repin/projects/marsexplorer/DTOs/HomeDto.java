package com.evgeniy_repin.projects.marsexplorer.DTOs;

public class HomeDto {
    private String marsExplorerName;
    private Integer sol;
    private Boolean cameraFHAZ;
    private Boolean cameraRHAZ;
    private Boolean cameraMAST;
    private Boolean cameraCHEMCAM;
    private Boolean cameraMAHLI;
    private Boolean cameraMARDI;
    private Boolean cameraNAVCAM;
    private Boolean cameraPANCAM;
    private Boolean cameraMINITES;

    public String getMarsExplorerName() {
        return marsExplorerName;
    }
    public void setMarsExplorerName(String marsExplorerName) {
        this.marsExplorerName = marsExplorerName;
    }

    public Integer getSol() {
        return sol;
    }
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public Boolean getCameraFHAZ() {
        return cameraFHAZ;
    }
    public void setCameraFHAZ(Boolean cameraFHAZ) {
        this.cameraFHAZ = cameraFHAZ;
    }

    public Boolean getCameraRHAZ() {
        return cameraRHAZ;
    }
    public void setCameraRHAZ(Boolean cameraRHAZ) {
        this.cameraRHAZ = cameraRHAZ;
    }

    public Boolean getCameraMAST() {
        return cameraMAST;
    }
    public void setCameraMAST(Boolean cameraMAST) {
        this.cameraMAST = cameraMAST;
    }

    public Boolean getCameraCHEMCAM() {
        return cameraCHEMCAM;
    }
    public void setCameraCHEMCAM(Boolean cameraCHEMCAM) {
        this.cameraCHEMCAM = cameraCHEMCAM;
    }

    public Boolean getCameraMAHLI() {
        return cameraMAHLI;
    }
    public void setCameraMAHLI(Boolean cameraMAHLI) {
        this.cameraMAHLI = cameraMAHLI;
    }

    public Boolean getCameraMARDI() {
        return cameraMARDI;
    }
    public void setCameraMARDI(Boolean cameraMARDI) {
        this.cameraMARDI = cameraMARDI;
    }

    public Boolean getCameraNAVCAM() {
        return cameraNAVCAM;
    }
    public void setCameraNAVCAM(Boolean cameraNAVCAM) {
        this.cameraNAVCAM = cameraNAVCAM;
    }

    public Boolean getCameraPANCAM() {
        return cameraPANCAM;
    }
    public void setCameraPANCAM(Boolean cameraPANCAM) {
        this.cameraPANCAM = cameraPANCAM;
    }

    public Boolean getCameraMINITES() {
        return cameraMINITES;
    }
    public void setCameraMINITES(Boolean cameraMINITES) {
        this.cameraMINITES = cameraMINITES;
    }
}
