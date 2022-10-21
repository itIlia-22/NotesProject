package com.example.notesproject.repository

import com.example.notesproject.model.Notes

interface NoteDeleteClick {
    fun onNoteDeleteClick(notes: Notes)
}