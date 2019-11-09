package com.example.bookcrossing.presentation.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.home_fragment.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)
        showBooks(createBooks())
    }
    private fun createBooks(): ArrayList<Book> {
        var booksArrayList=ArrayList<Book>()
        booksArrayList.add(Book("Womens","asdasda","Charls Bukowsk",null,R.drawable.hpaps,false,null))
        return booksArrayList

    }
    private fun showBooks(books: List<Book>) {
        RecommendedRecycle.layoutManager = LinearLayoutManager(this)
        RecommendedRecycle.adapter = BookAdapter(books)
    }
}
