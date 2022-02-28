package com.mohamed_ramadan.code.mvvm_example;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel  {

    LiveData<String> MovieNameLiveDate ;
    MutableLiveData<String>MovieNameMutableLiveData =new MutableLiveData<>();

    public void GetName() {
        MovieNameMutableLiveData.setValue(GetMoviefromDB().getName());
    }
    private MovieModel GetMoviefromDB() {

        return new MovieModel("X-Men","Action","2017",1);
    }

}
