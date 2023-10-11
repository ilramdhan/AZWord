package com.dicoding.azword

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

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var wordAdapter: WordAdapter

    companion object {
        fun newInstance(selectedLetter: Char): WordListFragment {
            val fragment = WordListFragment()
            val args = Bundle()
            args.putChar("selectedLetter", selectedLetter)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewWordList)

        // Inisialisasi adapter untuk RecyclerView dan daftar kata sesuai huruf yang dipilih
        val selectedLetter = arguments?.getChar("selectedLetter") ?: 'A'
        val wordList = createWordList(selectedLetter)

        val wordAdapter = WordAdapter(wordList) { word ->
            // Menjalankan pencarian web saat item kata diklik
            (activity as MainActivity).openWebSearch(word.word)
        }

        recyclerView.adapter = wordAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Tambahkan Item Decoration dengan jarak yang sesuai (misalnya, 8dp)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        recyclerView.addItemDecoration(SpacingItemDecoration(spacingInPixels))

        return view
    }

    private fun createWordList(selectedLetter: Char): List<Word> {
        val wordList = mutableListOf<Word>()
        if (selectedLetter == 'A') {
            wordList.add(Word("Apple", "A fruit"))
            wordList.add(Word("Ant", "An insect"))
            wordList.add(Word("Airplane", "A vehicle"))
        }
        else if (selectedLetter == 'B') {
            wordList.add(Word("Banana", "A fruit"))
            wordList.add(Word("Bear", "A mammal"))
            wordList.add(Word("Bicycle", "A vehicle"))
        }
        else if (selectedLetter == 'C') {
            wordList.add(Word("Car", "A vehicle"))
            wordList.add(Word("Cat", "An animal"))
            wordList.add(Word("Cucumber", "A vegetable"))
        }
        else if (selectedLetter == 'D') {
            wordList.add(Word("Dog", "An animal"))
            wordList.add(Word("Dolphin", "A mammal"))
            wordList.add(Word("Duck", "A bird"))
        }
        else if (selectedLetter == 'E') {
            wordList.add(Word("Elephant", "A mammal"))
            wordList.add(Word("Eagle", "A bird"))
            wordList.add(Word("Eggplant", "A vegetable"))
        }
        else if (selectedLetter == 'F') {
            wordList.add(Word("Frog", "An amphibian"))
            wordList.add(Word("Fox", "A mammal"))
            wordList.add(Word("Fish", "An animal"))
        }
        else if (selectedLetter == 'G') {
            wordList.add(Word("Giraffe", "An animal"))
            wordList.add(Word("Goat", "An animal"))
            wordList.add(Word("Grape", "A fruit"))
        }
        else if (selectedLetter == 'H') {
            wordList.add(Word("Horse", "An animal"))
            wordList.add(Word("Hippo", "An animal"))
            wordList.add(Word("Honey", "A food"))
        }
        else if (selectedLetter == 'I') {
            wordList.add(Word("Ice cream", "A food"))
            wordList.add(Word("Iguana", "An animal"))
            wordList.add(Word("Insect", "An animal"))
        }
        else if (selectedLetter == 'J') {
            wordList.add(Word("Jellyfish", "An animal"))
            wordList.add(Word("Jaguar", "An animal"))
            wordList.add(Word("Jackfruit", "A fruit"))
        }

        return wordList
    }
}

class Word(val word: String, val meaning: String) {
    // Jika Anda membutuhkan properti lain atau metode, Anda dapat menambahkannya di sini
}
