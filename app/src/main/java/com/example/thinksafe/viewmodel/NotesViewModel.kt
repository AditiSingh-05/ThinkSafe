package com.example.thinksafe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thinksafe.model.Note
import com.google.firebase.firestore.FirebaseFirestore

class NotesViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _notes = MutableLiveData<List<Note>>()//Note.kt note
    val notes: LiveData<List<Note>> = _notes

    fun fetchNotes(userId: String) {
        db.collection("notes").whereEqualTo("userId", userId).get()
            .addOnSuccessListener { result ->
                val notesList = result.toObjects(Note::class.java)
                _notes.value = notesList
            }
    }

    fun addNote(note: Note) {
        db.collection("notes").add(note)
    }

    fun deleteNote(noteId: String) {
        db.collection("notes").document(noteId).delete()
    }
}