package com.mohamed_ramadan.code.recyclerview;

public class Model {
    private int id;
    private String Name;
    private String Age;

    public Model(int id, String name, String age) {
        this.id = id;
        Name = name;
        Age = age;
    }

    public Model() {
    }


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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
