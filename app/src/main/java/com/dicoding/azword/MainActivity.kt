package com.dicoding.azword

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AlphabetFragment.OnLetterSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menampilkan AlphabetFragment saat aplikasi pertama kali dijalankan
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlphabetFragment())
                .commit()
        }
    }

    override fun onLetterSelected(letter: Char) {
        // Menampilkan WordListFragment dengan huruf yang sesuai saat huruf diklik
        val wordListFragment = WordListFragment.newInstance(letter)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, wordListFragment)
            .addToBackStack(null)
            .commit()
    }

    // Fungsi untuk menampilkan web intent untuk kata yang dipilih
    fun openWebSearch(word: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, word)
        startActivity(intent)
    }
}
