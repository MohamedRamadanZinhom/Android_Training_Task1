package com.mohamed_ramadan.code.roomdb_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "posts_table")
public class Posts  {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    private int user_id;
    private String title;
    private String body;

    public Posts( int user_id, String title, String body) {

        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
