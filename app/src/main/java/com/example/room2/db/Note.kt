package com.example.room2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)

class Note(
    @ColumnInfo(name = "noteTitle") val noteTitle: String,
    @ColumnInfo(name = "noteDesc") val noteDesc: String,
    @ColumnInfo(name = "noteImage") val noteImage: String
) {
    @PrimaryKey(autoGenerate = true) var id = 0
}