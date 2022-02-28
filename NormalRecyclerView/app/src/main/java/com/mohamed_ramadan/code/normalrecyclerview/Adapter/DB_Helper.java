package com.mohamed_ramadan.code.normalrecyclerview.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import  com.mohamed_ramadan.code.normalrecyclerview.Adapter.DB_Contract.Quiz_DB;
import com.mohamed_ramadan.code.normalrecyclerview.Model.Quiz;

import java.util.ArrayList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {

    private static final String COMMAND=" CREATE TABLE "+
           Quiz_DB.TABLE_NAME + " (" +
            Quiz_DB._ID + "INTEGER PRIMARY KEY AUTOINCREMENT ," +
            Quiz_DB.QUESTION_COLUMN + "TEXT ," +
            Quiz_DB.OPTION1_COLUMN + "TEXT ," +
            Quiz_DB.OPTION2_COLUMN + "TEXT ," +
            Quiz_DB.OPTION3_COLUMN + "TEXT ," +
            Quiz_DB.ANSWER_NO_COLUMN +"INTEGER ," +
            Quiz_DB.QUIZ_CODE_COLUMN + "INTEGER " +
            ")";
    private SQLiteDatabase db;

    public DB_Helper(@Nullable Context context) {
        super(context,Quiz_DB.DATABASE_NAME, null, Quiz_DB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      this.db=db;
      db.execSQL(COMMAND);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Quiz_DB.TABLE_NAME);
        onCreate(db);
    }



    public void Add(Quiz quiz) {
      SQLiteDatabase   db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Quiz_DB.QUESTION_COLUMN,quiz.getQuestion());
        cv.put(Quiz_DB.OPTION1_COLUMN,quiz.getOption1());
        cv.put(Quiz_DB.OPTION2_COLUMN,quiz.getOption2());
        cv.put(Quiz_DB.OPTION3_COLUMN,quiz.getOption3());
        cv.put(Quiz_DB.ANSWER_NO_COLUMN,quiz.getAnswer_No());
        cv.put(Quiz_DB.QUIZ_CODE_COLUMN,quiz.getQuiz_Code());
        db.insert(Quiz_DB.TABLE_NAME,null,cv);
        db.close();
    }

    public  List<Quiz> GetAll() {
        List<Quiz> quizList =new ArrayList<>();
        SQLiteDatabase  db =getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM "+ Quiz_DB.TABLE_NAME,null);
        if(cursor.moveToFirst()) {
            do {
                Quiz quiz=new Quiz();
                quiz.setAnswer_No(cursor.getInt(cursor.getColumnIndex(Quiz_DB.ANSWER_NO_COLUMN)));
                quiz.setQuiz_Code(cursor.getInt(cursor.getColumnIndex(Quiz_DB.QUIZ_CODE_COLUMN)));
                quiz.setOption1(cursor.getString(cursor.getColumnIndex(Quiz_DB.OPTION1_COLUMN)));
                quiz.setOption2(cursor.getString(cursor.getColumnIndex(Quiz_DB.OPTION2_COLUMN)));
                quiz.setOption3(cursor.getString(cursor.getColumnIndex(Quiz_DB.OPTION3_COLUMN)));
                quiz.setQuestion(cursor.getString(cursor.getColumnIndex(Quiz_DB.QUESTION_COLUMN)));
                quizList.add(quiz);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return quizList ;
    }


}
