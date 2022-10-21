package com.example.notesproject.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesproject.R
import com.example.notesproject.databinding.NoteRvItemBinding
import com.example.notesproject.model.Notes
import com.example.notesproject.repository.NoteDeleteClick
import com.example.notesproject.repository.NoteUpdateClick

class NotesAdapter(
    private val context: Context,
    private val noteDeleteClick: NoteDeleteClick,
    private val noteUpdateClick: NoteUpdateClick,

    ) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)!!
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)!!
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = NoteRvItemBinding.inflate(LayoutInflater.from(context.applicationContext),
            parent, false)
        return MyViewHolder(binding.root)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.noteTV.text = allNotes[position].title
        holder.dateTV.text = "Last Update : " + allNotes[position].timestamp
        holder.deleteIV.setOnClickListener {
            noteDeleteClick.onNoteDeleteClick(allNotes[position])
        }
        holder.itemView.setOnClickListener {
            noteUpdateClick.onNoteUpClick(allNotes[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdateList(newList:List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = allNotes.size

}