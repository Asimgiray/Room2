package com.example.room2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        @Volatile
        private var instance: NoteDatabase? = null


        fun getDatabaseInstance(context: Context) : NoteDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                instance = newInstance
                newInstance
            }
        }


    }


}