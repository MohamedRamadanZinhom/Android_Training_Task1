package com.mohamed_ramadan.code.kotlin_roomdb.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable

@Entity(tableName = "user_table")
class User (
    @PrimaryKey(autoGenerate = true)
      val Id:Int,
      val Firstname :String ,
       val LastNAme :String,
      val Age :Int
)



