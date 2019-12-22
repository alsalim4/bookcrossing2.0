package com.example.bookcrossing.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookcrossing.R
import com.example.bookcrossing.presentation.book.Book
import com.example.bookcrossing.presentation.book.BookAdapter
import kotlinx.android.synthetic.main.activity_book.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.profile_activity.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        showBooks(createBooks())
    }
    private fun createBooks(): ArrayList<Book> {
        var booksArrayList = ArrayList<Book>()
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        return booksArrayList
    }
    private fun showBooks(books: List<Book>) {
        activeBooksRecyclerView.layoutManager = GridLayoutManager(this,2)
        activeBooksRecyclerView.adapter = BookAdapter(books)
    }
}