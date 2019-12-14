package com.example.bookcrossing.presentation.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.R
import com.google.firebase.storage.FirebaseStorage
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
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null,R.drawable.bukowski, null,false, null))

        return booksArrayList

    }
    private fun showBooks(books: List<Book>) {
        RecommendedRecycle.layoutManager = GridLayoutManager(context,2)
        RecommendedRecycle.adapter = BookAdapter(books)
    }
}


