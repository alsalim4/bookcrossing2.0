package com.example.bookcrossing.presentation.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter (val books:List<Book>): RecyclerView.Adapter<BookAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).
            inflate(R.layout.item_book,parent,false))
    }

    override fun getItemCount()=books.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book=books[position]
        book.rating?.let {
            holder.view.rating.numStars = it.toInt()
        }
        holder.view.authorBook.text = book.author
        holder.view.tvTitleBook.text = book.name
        holder.view.tvTitleBook.text = book.name
        if (book.taken==false){
            holder.view.NOTtakenBtn.text=" available"
        }
        else {
            holder.view.NOTtakenBtn.text=" not available"
        }

            Glide.with(holder.view.context)
               .load(book.photo)
               .into(holder.view.ivBook)
    }

    class BooksViewHolder (val view: View) : RecyclerView.ViewHolder(view)
}