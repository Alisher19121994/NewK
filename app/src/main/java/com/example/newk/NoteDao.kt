package com.example.newk

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: Note)

    @Query("SELECT*FROM note_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Note>>
}