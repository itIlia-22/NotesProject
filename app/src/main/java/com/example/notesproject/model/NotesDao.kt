package com.example.notesproject.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(notes: Notes)

    @Delete
    fun delete(notes: Notes)

    @Update
    fun update(notes: Notes)
@Query("SELECT * FROM tableNote order by id ASC")
    fun getAllNotes():LiveData<List<Notes>>
}