package com.example.newk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity:  AppCompatActivity() {
    private lateinit var mUserViewModel: NoteViewModal
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mUserViewModel = ViewModelProvider(this)[NoteViewModal::class.java]
        val adapter = NoteRVAdapter()
        recyclerView.adapter = adapter
        mUserViewModel.readAllData.observe(this, Observer { user ->
            adapter.setData(user)
        })

        fab.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            val inflater = this.layoutInflater
            val mView = inflater.inflate(R.layout.dialog, null)
            val etEmail: EditText = mView.findViewById(R.id.etEmail)

            dialogBuilder.setView(mView)
            dialogBuilder.setPositiveButton(
                "SAVE"
            ) { p0, p1 ->

                val title = etEmail.text.toString()
                val user = Note(0, title,  "oct 17")
                mUserViewModel.addUser(user)
            }
            dialogBuilder.setNegativeButton(
                "CANCEL"
            ) { p0, p1 ->

            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }

    }
}