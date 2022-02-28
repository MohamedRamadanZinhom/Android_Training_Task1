package com.mohamed_ramadan.code.mvvm_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ActivityManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



   private MovieViewModel movieViewModel;
   private RecyclerView recyclerView;

   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MovieListAdapter adapter=new MovieListAdapter();
        recyclerView.setAdapter(adapter);
        btn=findViewById(R.id.btnget);
        movieViewModel= new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.moviemuArrayListMutableLiveData.observe(this, new Observer<ArrayList<MovieModel>>() {
            @Override
            public void onChanged(ArrayList<MovieModel> movieModels) {
                adapter.SetList(movieModels);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movieViewModel.GetData();

            }
        });


    }
}