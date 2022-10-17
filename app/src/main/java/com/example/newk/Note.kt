package com.example.newk

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
open class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var time: String
)