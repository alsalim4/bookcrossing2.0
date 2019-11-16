package com.example.bookcrossing.presentation.notification

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.R
import com.example.bookcrossing.entities.User
import com.example.bookcrossing.presentation.book.Book
import com.example.bookcrossing.presentation.book.BookAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.yourbooks_fragment.*

class YourBooks_fragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.bookcrossing.R.layout.yourbooks_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioGroupYourBooks.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.yourBooks_radio_button -> {
                    yourBooks_radio_button.setTextColor(Color.WHITE)
                    otherBooks_radio_button.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
                    OtherBooksLayout.visibility = View.GONE
                    yourBooksLayout.visibility = View.VISIBLE
                }
                R.id.otherBooks_radio_button -> {
                    yourBooks_radio_button.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
                    otherBooks_radio_button.setTextColor(Color.WHITE)
                    OtherBooksLayout.visibility = View.VISIBLE
                    yourBooksLayout.visibility = View.GONE
                }
            }
            showBooks(createBooks())
        }
    }
    private fun createBooks(): ArrayList<Book> {
        var booksArrayList = ArrayList<Book>()
        val user= User("alsalim","baizhanovAlsalim","123",R.drawable.hpaps)
        booksArrayList.add(Book("Womens", "asdasda", "Charls Bukowsk", null, R.drawable.hpaps,user ,false, null))
        return booksArrayList
    }

    private fun showBooks(books: List<Book>) {
        YourBooks.layoutManager = LinearLayoutManager(context)
        YourBooks.adapter = YourBooksAdapter(books)
        OtherBooks.layoutManager = LinearLayoutManager(context)
        OtherBooks.adapter = YourBooksAdapter(books)
    }
}