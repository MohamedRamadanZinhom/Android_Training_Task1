package com.mohamed_ramadan.code.mvvm_recyclerview;

public class MovieModel {

    private int id;
    private String Name;
    private String Year;

    public MovieModel(int id, String name, String year) {
        this.id = id;
        Name = name;
        Year = year;
    }
    public MovieModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
