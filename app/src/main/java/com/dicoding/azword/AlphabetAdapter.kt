package com.dicoding.azword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(private val letters: List<Char>, private val itemClickListener: (Char) -> Unit) :
    RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alphabet, parent, false)
        return AlphabetViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        val letter = letters[position]
        holder.bind(letter)
    }

    override fun getItemCount(): Int = letters.size

    inner class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(letter: Char) {
            itemView.findViewById<TextView>(R.id.letterTextView).text = letter.toString()
            itemView.setOnClickListener { itemClickListener(letter) }
        }
    }
}