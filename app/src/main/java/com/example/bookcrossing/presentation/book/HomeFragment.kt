package com.example.bookcrossing.presentation.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.bookcrossing.R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBooks(createBooks())
    }

    private fun createBooks(): ArrayList<Book> {
        var booksArrayList = ArrayList<Book>()
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null, R.drawable.hpaps, false, null))
        return booksArrayList

    }

    private fun showBooks(books: List<Book>) {
        RecommendedRecycle.layoutManager = LinearLayoutManager(context)
        RecommendedRecycle.adapter = BookAdapter(books)
    }
}


