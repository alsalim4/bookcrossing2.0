package com.example.bookcrossing.presentation.genre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(val genres:List<GenreItem>): RecyclerView.Adapter<GenreAdapter.GenresViewHolder>() {
    override fun getItemCount()=genres.size

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genreItem=genres[position]
        holder.view.genreItemText.text=genreItem.name
        Glide.with(holder.view.context)
            .load(genreItem.img)
            .into(holder.view.GenreIcon)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        return GenresViewHolder(
            LayoutInflater.from(parent.context).
                inflate(R.layout.item_genre,parent,false))
    }
    class GenresViewHolder(val view : View): RecyclerView.ViewHolder(view)
}