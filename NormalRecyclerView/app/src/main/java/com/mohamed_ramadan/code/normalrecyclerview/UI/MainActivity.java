package com.mohamed_ramadan.code.normalrecyclerview.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mohamed_ramadan.code.normalrecyclerview.Adapter.DB_Helper;
import com.mohamed_ramadan.code.normalrecyclerview.Adapter.MyAdapter;
import com.mohamed_ramadan.code.normalrecyclerview.Model.Man;
import com.mohamed_ramadan.code.normalrecyclerview.Model.Quiz;
import com.mohamed_ramadan.code.normalrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    Button btn;
    RecyclerView recyclerView;
    List<Quiz>men;
    private RecyclerView.Adapter adapter  ;
    private DB_Helper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=new DB_Helper(this);
        men=new ArrayList<>();
        Fill();
        Data_From_DB();
        fill();
        btn=findViewById(R.id.btnget);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new MyAdapter(men,db);
                recyclerView.setAdapter(adapter);
            }
        });



    }


    public void Data_From_DB() {
        men = db.GetAll();
    }

    void fill() {
        Quiz quiz=new Quiz("A is Correct","A","B","C",1,111);
        men.add(quiz);
        Quiz quiz1=new Quiz("B is Correct","A","B","C",2,111);
        men.add(quiz1);
        Quiz quiz2=new Quiz("C is Correct","A","B","C",3,111);
        men.add(quiz2);
        Quiz quiz3=new Quiz("C is Correct","A","B","C",3,111);
        men.add(quiz3);
        Quiz quiz4=new Quiz("B is Correct","A","B","C",2,111);
        men.add(quiz4);
    }
    public void Fill() {
        Quiz quiz=new Quiz("A is Correct","A","B","C",1,111);
       db.Add(quiz);
        Quiz quiz1=new Quiz("B is Correct","A","B","C",2,111);
        db. Add(quiz1);
        Quiz quiz2=new Quiz("C is Correct","A","B","C",3,111);
        db.Add(quiz2);
        Quiz quiz3=new Quiz("C is Correct","A","B","C",3,111);
        db.Add(quiz3);
        Quiz quiz4=new Quiz("B is Correct","A","B","C",2,111);
        db.Add(quiz4);
    }


}