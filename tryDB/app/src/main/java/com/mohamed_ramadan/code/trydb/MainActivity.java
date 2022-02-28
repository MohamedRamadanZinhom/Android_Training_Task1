package com.mohamed_ramadan.code.trydb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mohamed_ramadan.code.trydb.Controler.DB_Helper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView scrollView;
    Button button;
    TextView txt;
    List<Task> tasks=new ArrayList<>();
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);



       txt= findViewById(R.id.txt);


        Task task =new Task("play","football",1);
        Task task2 =new Task("play","teness",2);
        Task task3 =new Task("play","tawla",3);
        Task task4 =new Task("play","rugby",4);



        DB_Helper db_helper=new DB_Helper(this);

        db_helper.insertTask(task);
        db_helper.insertTask(task2);
        db_helper.insertTask(task3);
        db_helper.insertTask(task4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tasks = db_helper.getAllTasks();
                if(x<tasks.size()){
                    int y = tasks.size();
                txt.setText(tasks.get(x).getTask().toString() + " "+ y +""+ x);

                }
                x++;

            }
        });




    }
}