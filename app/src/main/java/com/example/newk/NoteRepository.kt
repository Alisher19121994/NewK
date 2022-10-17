package com.example.newk

import androidx.lifecycle.LiveData
import com.example.newk.Note

class NoteRepository(private var userDao: NoteDao) {

    val readAllData: LiveData<List<Note>> =
        userDao.readAllData()

    fun addUser(user: Note){
        userDao.addUser(user)
    }

}