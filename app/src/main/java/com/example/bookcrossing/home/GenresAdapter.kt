package com.example.bookcrossing.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.item_genre.view.*


class GenresAdapter(private var dataset: ArrayList<GenreItem>,
                    private val listener: OnItemClickListener
)
    : RecyclerView.Adapter<GenresAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataset[position])
    }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        fun bind(item: GenreItem){
            itemView.ivIconGenre.setImageResource(item.img!!)
            itemView.genreItemText.text = item.name
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.onGenreItemClicked(dataset[adapterPosition])
        }
    }

    interface OnItemClickListener {
        fun onGenreItemClicked(item: GenreItem)
    }
}