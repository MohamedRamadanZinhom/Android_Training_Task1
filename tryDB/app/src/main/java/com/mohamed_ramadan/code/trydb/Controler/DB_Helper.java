package com.mohamed_ramadan.code.trydb.Controler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mohamed_ramadan.code.trydb.Controler.DBContract.Task_DB;
import com.mohamed_ramadan.code.trydb.Task;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DB_Helper extends SQLiteOpenHelper {

    private static final String name="Task";
    private static final int version=1;

    private static final String CREATE_TODO_TABLE = "CREATE TABLE " + Task_DB.Task_TABLE + "(" + Task_DB.ID_COLUMMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Task_DB.TASK_COLUMMN + " TEXT, "
            + Task_DB.TASK_TITLE_COLUMMN + " TEXT )";

    public DB_Helper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Task_DB.Task_TABLE );
        // Create tables again
        onCreate(db);
    }

    public void insertTask(Task task){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Task_DB.TASK_COLUMMN, task.getTask());
        cv.put(Task_DB.TASK_TITLE_COLUMMN, task.getTitle());

        db.insert(Task_DB.Task_TABLE, null, cv);
    }

    public List<Task> getAllTasks(){

        // SQLiteDatabase db = new  SQLiteDatabase();
        List<Task> taskList = new ArrayList<>();
        Cursor cur = null;
        //db.beginTransaction();
        try{
            SQLiteDatabase db = getReadableDatabase();
            cur = db.query(Task_DB.Task_TABLE , null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        Task task = new Task();
                        task.setId(cur.getInt(cur.getColumnIndex(Task_DB.ID_COLUMMN)));
                        task.setTask(cur.getString(cur.getColumnIndex(Task_DB.TASK_COLUMMN)));
                        task.setTitle(cur.getString(cur.getColumnIndex(Task_DB.TASK_TITLE_COLUMMN)));

                        taskList.add(task);
                    }
                    while(cur.moveToNext());
                }
            }
        }
        finally {
           // db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return taskList;
    }


}
