package com.mohamed_ramadan.code.roomdb_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Posts.class, version = 1)
public abstract class PostsDataBase extends RoomDatabase {


    private static PostsDataBase instace;
    public  abstract Dao PostsDao() ;

    public static synchronized PostsDataBase getInstace (Context context){

        if(instace ==null){
            instace= Room.databaseBuilder(context.getApplicationContext()
                    ,PostsDataBase.class,"postes_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
         return instace;
    }


}
