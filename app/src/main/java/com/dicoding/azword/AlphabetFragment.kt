package com.dicoding.azword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AlphabetFragment : Fragment() {
    // Deklarasikan interface untuk berkomunikasi dengan MainActivity
    interface OnLetterSelectedListener {
        fun onLetterSelected(letter: Char)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var alphabetAdapter: AlphabetAdapter
    private var listener: OnLetterSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewAlphabet)

        // Inisialisasi adapter untuk RecyclerView
        val letters = ('A'..'Z').toList()
        alphabetAdapter = AlphabetAdapter(letters) { letter ->
            // Panggil callback ke MainActivity saat huruf diklik
            listener?.onLetterSelected(letter)
        }

        recyclerView.adapter = alphabetAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLetterSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnLetterSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


}