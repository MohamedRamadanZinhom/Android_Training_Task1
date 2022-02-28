package com.mohamed_ramadan.code.sampledb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DB_Helper db;
    TextView textView;
    Button btn;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new DB_Helper(this);
        Person person=new Person("Mohamed","1");
        db.Add(person);
        textView=findViewById(R.id.textView);
        btn =findViewById(R.id.button);
         personList=db.GetAll();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(personList.get(0).getName());
            }
        });



    }
}