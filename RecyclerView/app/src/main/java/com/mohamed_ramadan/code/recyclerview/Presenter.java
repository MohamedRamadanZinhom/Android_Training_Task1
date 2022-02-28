package com.mohamed_ramadan.code.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
    Presenter_View_API API;

    public Presenter(Presenter_View_API View) {
        this.API = View;
    }

    private List<Model> getDataFrom_DB() {
        List<Model> modelList=new ArrayList<>();
        modelList.add(new Model(1,"mohamed","20"));
        modelList.add(new Model(2,"mohamed Ramadan","23"));
        modelList.add(new Model(3,"mohamed Zinhom","22"));
        modelList.add(new Model(4,"mohamed Khalil","21"));

        return modelList;
    }

    public void getDate()
    {
        API.Getmodel(getDataFrom_DB());
    }



}
