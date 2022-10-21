package com.example.notesproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableNote")
class Notes (
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "description")
    val description:String,
    @ColumnInfo(name = "timestamp")
    val timestamp:String,
){
    @PrimaryKey(autoGenerate = true) var id = 0
}