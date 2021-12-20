package com.example.universitieslisview.models;

public class School {
    private int id;
    private String name;

    public String getFullname() {
        return fullname;
    }

    private String fullname;
    private String city;
    private int nbrBranches;
    private int id_uni;

    public School(int id, String name,String fullname, String city, int nbrBranches, int id_uni) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.city = city;
        this.nbrBranches = nbrBranches;
        this.id_uni = id_uni;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrBranches() {
        return nbrBranches;
    }

    public void setNbrBranches(int nbrBranches) {
        this.nbrBranches = nbrBranches;
    }

    public int getId_uni() {
        return id_uni;
    }

    public void setId_uni(int id_uni) {
        this.id_uni = id_uni;
    }
}
