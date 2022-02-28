package com.mohamed_ramadan.code.sampledb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.mohamed_ramadan.code.sampledb.DB_Contract;

import java.util.ArrayList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {


    public DB_Helper(@Nullable Context context) {
        super(context, DB_Contract.DATABASE_NAME, null, DB_Contract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         final String COMMAND=" CREATE TABLE "+
                 DB_Contract.TABLE_NAME + " (" +
                 DB_Contract.ID_COLUMN + "TEXT ," +
                 DB_Contract.NAME_COLUMN + "TEXT  " +
                " ) ";

         db.execSQL(COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +DB_Contract.TABLE_NAME);
        onCreate(db);
    }

    public void Add(Person person) {
        SQLiteDatabase   db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DB_Contract.ID_COLUMN,person.getID());
        cv.put(DB_Contract.NAME_COLUMN,person.getName());

        db.insert(DB_Contract.TABLE_NAME,null,cv);
        db.close();
    }

    public List<Person> GetAll() {
        List<Person> quizList =new ArrayList<>();

        SQLiteDatabase  db =getReadableDatabase();
       // Cursor cursor =db.rawQuery("SELECT * FROM "+ DB_Contract.TABLE_NAME,null);
        Cursor cur = null;
        db.beginTransaction();
        try{
            cur = db.query(DB_Contract.TABLE_NAME, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        Person quiz=new Person();
                        quiz.setID(cur.getString(cur.getColumnIndex(DB_Contract.ID_COLUMN)));
                        quiz.setName(cur.getString(cur.getColumnIndex(DB_Contract.NAME_COLUMN)));

                        quizList.add(quiz);
                    }
                    while(cur.moveToNext());
                }
            }
        }
        finally {
            db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return quizList;




        /* if(cursor.moveToFirst()) {
            do {
                Person quiz=new Person();
                quiz.setID(cursor.getString(cursor.getColumnIndex(DB_Contract.ID_COLUMN)));
                quiz.setName(cursor.getString(cursor.getColumnIndex(DB_Contract.NAME_COLUMN)));

                quizList.add(quiz);
            }while (cursor.moveToNext());
        }
        cursor.close();*/
        //return quizList ;
    }



}
