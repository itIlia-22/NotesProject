package com.example.notesproject.repository

import androidx.lifecycle.LiveData
import com.example.notesproject.model.Notes
import com.example.notesproject.model.NotesDao

class NoteRepository(private val notesDao: NotesDao) {
    val allNote: LiveData<List<Notes>> = notesDao.getAllNotes()

    fun insert(notes: Notes) {
        notesDao.insert(notes)
    }

    fun delete(notes: Notes) {
        notesDao.delete(notes)
    }

    fun update(notes: Notes) {
        notesDao.update(notes)
    }
}