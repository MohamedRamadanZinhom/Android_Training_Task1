package com.mohamed_ramadan.code.roomdb_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostsDataBase postsDataBase =PostsDataBase.getInstace(this);

        postsDataBase.PostsDao().InsertPost(new Posts(1,"welcome","hello world"));

    }
}