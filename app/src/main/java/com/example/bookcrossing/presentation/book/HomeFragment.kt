package com.example.bookcrossing.presentation.book

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrossing.R
import com.example.bookcrossing.entities.Sample
import com.example.bookcrossing.presentation.genre.GenreListActivity
import com.example.bookcrossing.presentation.profile.ProfileActivity
import com.example.bookcrossing.presentation.sample.SampleAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(),BookAdapter.MyClickListener{
    private var adapter: BookAdapter? = null

    private lateinit var database: DatabaseReference

    override fun onClick(item: Book) {
        val loginIntent = Intent(context, BookActivity::class.java)
        activity?.startActivity(loginIntent)
    }

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
        adapter = BookAdapter(books)
        adapter?.setListener(this)
        RecommendedRecycle.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        RecommendedRecycle.adapter = adapter
    }

}


