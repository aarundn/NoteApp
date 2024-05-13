package com.example.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.Note
import com.example.notes.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    app: Application,
    private val repository: NoteRepository
) : AndroidViewModel(app) {
    fun addNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }
    fun removeNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }
    fun getAllNotes() = repository.getAllNotes()
    fun searchNote(query: String?) = repository.searchNotes(query)

}