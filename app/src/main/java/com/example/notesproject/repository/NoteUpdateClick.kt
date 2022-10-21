package com.example.notesproject.repository

import com.example.notesproject.model.Notes

interface NoteUpdateClick {
    fun onNoteUpClick(notes: Notes)
}