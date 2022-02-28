package com.example.quiz_app_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView currant_score;
    TextView Timer;
    TextView Ques_No;
    TextView Question;

    RadioGroup RG;
    RadioButton R1;
    RadioButton R2;
    RadioButton R3;

    Button Next;

    private ColorStateList Rb_Default_Color;

     List<Question> all;

    private int Total_Questions;
    private int Score;
    private int Counter;

    private boolean Answered;
    private Question Current_Question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        all=new ArrayList<>();

        //Text View

        currant_score=findViewById(R.id.q_Score);
        Timer=findViewById(R.id.Timer);
        Ques_No=findViewById(R.id.question_count);
        Question=findViewById(R.id.Question_View);

        //Radio Button
        RG=findViewById(R.id.RG);
        R1=findViewById(R.id.R_btn1);
        R2=findViewById(R.id.R_btn2);
        R3=findViewById(R.id.R_btn3);

        //Button
        Next=findViewById(R.id.Next);

        //DB
       Quiz_DB_Helper dbHelper =new Quiz_DB_Helper(this);
        all =dbHelper.Get_All_Question();
        //all=new ArrayList<>();
        fillall();


        // Start Coding

        Rb_Default_Color=R1.getTextColors();
        Total_Questions =all.size();
        Collections.shuffle(all);


        ShowNextQuestion();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Answered) {
                    if(R1.isChecked() || R2.isChecked() || R3.isChecked()  ) {
                        CheckAnswer();
                    }
                    else {
                        Toast.makeText( QuizActivity.this,"Please Select an Answer",Toast.LENGTH_LONG);
                    }
                }
                else {
                   ShowNextQuestion();
                }
            }
        });



    }





    private void ShowNextQuestion() {
        R1.setTextColor(Rb_Default_Color);
        R2.setTextColor(Rb_Default_Color);
        R3.setTextColor(Rb_Default_Color);

        RG.clearCheck();

        if(Counter< Total_Questions) {
            Current_Question=all.get(Counter);
            Question.setText(Current_Question.getQuestion());
            R1.setText(Current_Question.getOption1());
            R2.setText(Current_Question.getOption2());
            R3.setText(Current_Question.getOption3());
            Counter++;
            Ques_No.setText("Question : "+Counter + "/" + Total_Questions);
            Answered = false;
            Next.setText("Confirm");
        }
        else
        {
            FinishQuiz();
        }


    }

    private void CheckAnswer() {
        Answered=true;
        RadioButton RB =findViewById(RG.getCheckedRadioButtonId());
        int no = RG.indexOfChild(RB) + 1;

        if(no == Current_Question.getAnswerNO()) {
            Score++;
            currant_score.setText("Score : " +Score);
        }

        ShowSolution();

    }
    private void ShowSolution() {
        R1.setTextColor(Color.RED);
        R2.setTextColor(Color.RED);
        R3.setTextColor(Color.RED);

        switch (Current_Question.getAnswerNO()) {

            case 1:
                R1.setTextColor(Color.GREEN);
                break;
            case 2:
                R2.setTextColor(Color.GREEN);
                break;
            case 3:
                R3.setTextColor(Color.GREEN);
                break;
        }

        if(Counter < Total_Questions) {
            Next.setText(" Next ");
        }
        else {
            Next.setText(" Finish ");
        }
    }
    private void FinishQuiz() {
        finish();
    }

    private void fillall()
    {
        Question question=new Question("A is Correct !", "A","B","C",1);
        all.add(question);
        Question question2=new Question("B is Correct !", "A","B","C",2);
        all.add(question2);
        Question question3=new Question("C is Correct !", "A","B","C",3);
        all.add(question3);
        Question question4=new Question("A is Correct !", "A","B","C",1);
        all.add(question4);
        Question question5=new Question("B is Correct !", "A","B","C",2);
        all.add(question5);
    }

}