package com.example.universitieslisview.models;

public class University {
    private int id;
    private String name;
    private String region;
    private int nbrSchool;
    private int imageId;

    public University(int id, String name, String region, int nbrSchool,int imageId) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.nbrSchool = nbrSchool;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getNbrSchool() {
        return nbrSchool;
    }

    public void setNbrSchool(int nbrSchool) {
        this.nbrSchool = nbrSchool;
    }

    public int getUniImage() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
