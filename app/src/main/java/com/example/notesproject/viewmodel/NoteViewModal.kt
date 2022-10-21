package com.example.notesproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notesproject.model.NoteDataBase
import com.example.notesproject.model.Notes
import com.example.notesproject.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>
    private val repository: NoteRepository

    init {
        val dao = NoteDataBase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNote

    }

    fun deleteNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }

    fun insertNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }

    fun updateNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(notes)
    }
}