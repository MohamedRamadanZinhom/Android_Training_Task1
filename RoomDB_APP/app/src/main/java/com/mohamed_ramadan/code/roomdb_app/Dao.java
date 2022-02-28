package com.mohamed_ramadan.code.roomdb_app;

import java.util.List;
import androidx.room;
import androidx.room.*;

@Dao
public interface Dao {

    @Insert
    void InsertPost(Posts post);

    @Query("select * from posts_table")
     List<Posts> getposts();


}
