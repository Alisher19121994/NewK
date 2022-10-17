package com.example.newk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class NoteRVAdapter : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {
    private var items = emptyList<Note>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val time: TextView = itemView.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        holder.title.text = data.title
        holder.time.text = data.time
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(user: List<Note>) {
        this.items = user
        notifyDataSetChanged()
    }
}