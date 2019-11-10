package com.example.bookcrossing.presentation.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrossing.R
import com.example.bookcrossing.presentation.book.Book
import kotlinx.android.synthetic.main.item_book.view.*
import kotlinx.android.synthetic.main.item_news.view.*

class YourBooksAdapter (val books:List<Book>):RecyclerView.Adapter<YourBooksAdapter.YourBooksViewHolder>(){
    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: YourBooksViewHolder, position: Int) {
        val book=books[position]
        holder.view.bookName.text = book.name
        Glide.with(holder.view.context)
            .load(book.photo)
            .into(holder.view.boomImg)
        Glide.with(holder.view.context)
            .load(book.reader?.photo)
            .into(holder.view.boomImg)
        if (book.taken==false){
            holder.view.isReading.text=" закончил прочтение"
        }
        else {
            holder.view.isReading.text=" читает"
        }
        holder.view.name.text=book.reader?.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourBooksViewHolder {
        return YourBooksViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_news,parent,false))
    }
    class YourBooksViewHolder (val view: View):RecyclerView.ViewHolder(view)
}
