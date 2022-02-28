package com.mohamed_ramadan.code.mvvm_example;

public class MovieModel {
    private String Name;
    private String Desc;
    private String Date;
    private int ID;

    public MovieModel(String name, String desc, String date, int ID) {
        Name = name;
        Desc = desc;
        Date = date;
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    public String getDate() {
        return Date;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
