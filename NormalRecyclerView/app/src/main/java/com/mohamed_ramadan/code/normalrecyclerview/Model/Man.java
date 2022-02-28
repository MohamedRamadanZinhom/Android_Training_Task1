package com.mohamed_ramadan.code.normalrecyclerview.Model;

import android.content.Context;

import com.mohamed_ramadan.code.normalrecyclerview.Adapter.DB_Helper;

import java.util.List;

public class Man {
    private String Name;
    private Context context;

    public Man(String name ,Context context) {
        Name = name;
        this.context=context;
    }

    public Man() {
    }

    public Man(Context context) {
        this.context=context;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}
