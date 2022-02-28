package com.mohamed_ramadan.code.mvvm_recyclerview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {


    MutableLiveData<ArrayList<MovieModel>> moviemuArrayListMutableLiveData;

    public MovieViewModel() {
        this.moviemuArrayListMutableLiveData = new MutableLiveData<>();
    }

    public void GetData() {
        this.moviemuArrayListMutableLiveData.setValue(GetMovieFrom_DB());
    }

    private ArrayList<MovieModel> GetMovieFrom_DB() {
        ArrayList<MovieModel> movies =new ArrayList<>();
        movies.add(new MovieModel(1,"Z-Man","7/7/2020") );
        movies.add(new MovieModel(2,"Y-Man","7/7/2021") );
        movies.add(new MovieModel(3,"B-Man","7/7/2000") );
        movies.add(new MovieModel(4,"X-Man","7/7/2019") );
        movies.add(new MovieModel(5,"S-Man","3/7/2008") );
        return  movies;
    }
}
