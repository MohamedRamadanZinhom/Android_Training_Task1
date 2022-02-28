package com.mohamed_ramadan.code.mvvm_example;

public class MoviePresenter {
    MovieView View;

    public MoviePresenter(MovieView movieView) {
        this.View = movieView;
    }

    public MovieModel GetMoviefromDB() {
        return new MovieModel("X-Men","Action","2017",1);
    }

    public void getmoviename() {
        View.OnGetMovieName(GetMoviefromDB().getName());
    }

}
