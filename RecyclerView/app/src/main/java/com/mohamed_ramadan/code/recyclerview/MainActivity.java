package com.mohamed_ramadan.code.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Presenter_View_API {

    Presenter presenter;
    List<Model> list;
    RecyclerView recyclerView;
    Model_Adapter adapter;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new Model_Adapter();

         btn=findViewById(R.id.btnget);
         presenter=new Presenter(this);

         recyclerView=findViewById(R.id.Recycler);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toast.makeText(this,"Action",Toast.LENGTH_LONG);
    }

    private void Action()
    {
        presenter.getDate();

    }


    @Override
    public void Getmodel(List<Model> model) {

       adapter.SetData(model);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {
        Action();
    }
}