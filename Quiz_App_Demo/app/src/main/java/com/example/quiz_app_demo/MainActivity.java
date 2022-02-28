package com.example.quiz_app_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start =findViewById(R.id.StartQuiz);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartQuiz();
            }
        });

    }

    private void StartQuiz() {
        Intent intent =new Intent(MainActivity.this,QuizActivity.class);
        startActivity(intent);
    }
}