package com.example.newk


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val userDao = RoomManager.getDatabase(application).noteDao()
        repository = NoteRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}