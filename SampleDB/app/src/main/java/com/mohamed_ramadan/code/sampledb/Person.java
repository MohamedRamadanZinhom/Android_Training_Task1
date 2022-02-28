package com.mohamed_ramadan.code.sampledb;

public class Person  {
    String Name;
    String ID;

    public Person(String name, String ID) {
        Name = name;
        this.ID = ID;
    }

    public Person() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
