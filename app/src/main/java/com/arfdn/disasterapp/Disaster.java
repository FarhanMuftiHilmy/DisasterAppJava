package com.arfdn.disasterapp;

public class Disaster {
    private String nameDisaster;
    private String disasterType;

    public Disaster(String nameDisaster, String disasterType) {
        this.nameDisaster = nameDisaster;
        this.disasterType = disasterType;
    }

    public String getNameDisaster() {
        return nameDisaster;
    }

    public void setNameDisaster(String nameDisaster) {
        this.nameDisaster = nameDisaster;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }
}
