package com.mohamed_ramadan.code.mvvm_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends  AppCompatActivity  implements MovieView{

    TextView textView;
    Button btn;
    MoviePresenter Presenter;

    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        textView=findViewById(R.id.txt);

         Presenter=new MoviePresenter(this);

         movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
         movieViewModel.MovieNameMutableLiveData.observe(this, new Observer<String>() {
             @Override
             public void onChanged(String s) {
                 textView.setText(s);
             }
         });


         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               //  Presenter.getmoviename();
                 movieViewModel.GetName();
             }
         });

    }


    @Override
    public void OnGetMovieName(String name) {
        textView.setText(name);
    }
}