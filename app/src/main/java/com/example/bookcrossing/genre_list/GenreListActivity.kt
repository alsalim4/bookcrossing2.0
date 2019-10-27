package com.example.bookcrossing.genre_list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookcrossing.R
import com.example.bookcrossing.book.BookActivity
import com.example.bookcrossing.entities.Book
import com.example.bookcrossing.home.AllBooksAdapter
import com.google.android.gms.common.api.Api
import kotlinx.android.synthetic.main.activity_genre_list.*
import org.koin.android.ext.android.inject


class GenreListActivity : AppCompatActivity(), AllBooksAdapter.OnItemClickListener {

    lateinit var booksAdapter: AllBooksAdapter

    companion object {
        val KEY_GENRE = "KEY_GENRE"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_list)

        booksAdapter = AllBooksAdapter(this, this)
        listGenres.layoutManager = GridLayoutManager(this, 2)
        listGenres.adapter = booksAdapter


    }

    override fun onBookItemClicked(item: Book) {
        val intt = Intent(this, BookActivity::class.java)
        intt.putExtra(BookActivity.BOOK_ISNB, item.isbn)
        startActivity(intt)
    }


}
