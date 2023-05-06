package com.example.room2.note

import androidx.lifecycle.LiveData
import com.example.room2.db.Note
import com.example.room2.db.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

}