package com.example.room2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.room2.db.Note
import com.example.room2.db.NoteDatabase
import com.example.room2.note.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Thread0", Thread.currentThread().name)




        lifecycleScope.launch(Dispatchers.Main) {
            Log.d("Thread1", Thread.currentThread().name)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.d("Thread2", Thread.currentThread().name)
        }

        lifecycleScope.launch(Dispatchers.Unconfined) {
            Log.d("Thread3", Thread.currentThread().name)
        }

        lifecycleScope.launch(Dispatchers.Default) {
            Log.d("Thread4", Thread.currentThread().name)
        }


        val dao = NoteDatabase.getDatabaseInstance(this).getNoteDao()
        val repository = NoteRepository(dao)


        val note = Note(
            "title",
            "desc",
            "image"
        )

        val note2 = Note(
            "Şeyda",
            "kuvvetli",
            "image"
        )

        val note3 = Note(
            "çiğdem",
            "tok",
            "image"
        )

        lifecycleScope.launch {
            repository.addNote(note)
        }

        repository.allNotes.observe(this) { noteList ->
            noteList.forEach {
                Log.d("Detail", it.noteDesc)
            }
        }

    }
}