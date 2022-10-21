package com.example.notesproject.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesproject.databinding.ActivityMainBinding
import com.example.notesproject.model.Notes
import com.example.notesproject.repository.NoteDeleteClick
import com.example.notesproject.repository.NoteUpdateClick
import com.example.notesproject.view.NotesAdapter
import com.example.notesproject.viewmodel.NoteViewModal
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), NoteUpdateClick, NoteDeleteClick {

    lateinit var viewModal: NoteViewModal
    lateinit var notesRV: RecyclerView
    lateinit var addFab: FloatingActionButton
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        //init
        notesRV = binding.notesRV
        addFab = binding.idFAB
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModal::class.java]
        notesRV.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this, this, this)
        notesRV.adapter = adapter
        viewModal.allNotes.observe(this) { list ->
            list.let {
                adapter.setUpdateList(it)
            }
            addFab.setOnClickListener {
                val intent = Intent(this@MainActivity, AddActivity::class.java)
                startActivity(intent)
                this.finish()


            }
        }


    }

    override fun onNoteDeleteClick(notes: Notes) {
        viewModal.deleteNote(notes)
        Snackbar.make(binding.root, "${notes.title} Delete", Snackbar.LENGTH_SHORT).show()
    }

    override fun onNoteUpClick(notes: Notes) {
        val intent = Intent(this@MainActivity, AddActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", notes.title)
        intent.putExtra("noteDescription", notes.description)
        intent.putExtra("noteId", notes.id)
        startActivity(intent)
        this.finish()


    }


}