package com.example.quiz_app_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.quiz_app_demo.Quiz_Contract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Quiz_DB_Helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="MyQuiz.db";
    private static final int DATABASE_VERSION=1;

    private SQLiteDatabase db;

    public Quiz_DB_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db=db;

        final String CREATE_QUESTION_TABLE_COMMAND ="Create Table "+ QuestionsTable.TABLE_NAME +
                "(" + QuestionsTable._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NO + " INTEGER " + ")";

        db.execSQL(CREATE_QUESTION_TABLE_COMMAND);

        FillQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      this.db.execSQL("Drop Table If Exists "+ QuestionsTable.TABLE_NAME);
       onCreate(db);
    }



    public void Add_Question(Question question){

        ContentValues contentValues=new ContentValues();
        contentValues.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        contentValues.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        contentValues.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        contentValues.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        contentValues.put(QuestionsTable.COLUMN_ANSWER_NO,question.getAnswerNO());
        db.insert(QuestionsTable.TABLE_NAME,null,contentValues);

    }

    public List<Question> Get_All_Question(){

        List<Question> all = new ArrayList<>();
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME ,null);

        if(cursor.moveToFirst()){

            do {

                Question q=new Question();
                q.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                q.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                q.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                q.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                q.setAnswerNO(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NO)));
                all.add(q);

            }while(cursor.moveToNext());

        }

        cursor.close();

        return  all;

    }

    private void FillQuestions() {
        Question question=new Question("A is Correct !", "A","B","C",1);
        Add_Question(question);
        Question question2=new Question("B is Correct !", "A","B","C",2);
        Add_Question(question2);
        Question question3=new Question("C is Correct !", "A","B","C",3);
        Add_Question(question3);
        Question question4=new Question("A is Correct !", "A","B","C",1);
        Add_Question(question4);
        Question question5=new Question("B is Correct !", "A","B","C",2);
        Add_Question(question5);
    }

}
