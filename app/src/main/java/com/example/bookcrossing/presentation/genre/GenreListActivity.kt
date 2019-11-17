package com.example.bookcrossing.presentation.genre

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.MenuActivity
import com.example.bookcrossing.R
import kotlinx.android.synthetic.main.activity_genres.*

class
GenreListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres)
        toolbarAcceptIcon.setOnClickListener{
            val loginIntent = Intent(this, MenuActivity::class.java)
            startActivity(loginIntent)
        }

        showGenres(creategenres())
    }


    private fun creategenres():ArrayList<GenreItem> {
        var GenresArrayList = ArrayList<GenreItem>()
        GenresArrayList.add(GenreItem("Romance", R.drawable.rrr))
        GenresArrayList.add(GenreItem("Science", R.drawable.sss))
        GenresArrayList.add(GenreItem("Fiction", R.drawable.fff))
        GenresArrayList.add(GenreItem("Detective", R.drawable.detective))
        GenresArrayList.add(GenreItem("Drama", R.drawable.drama))
        GenresArrayList.add(GenreItem("Novel", R.drawable.novel))
        GenresArrayList.add(GenreItem("Mystery", R.drawable.mystery))
        GenresArrayList.add(GenreItem("Fantasy", R.drawable.fantasy))
        GenresArrayList.add(GenreItem("Thriller", R.drawable.thriller))
        GenresArrayList.add(GenreItem("History", R.drawable.history))
        GenresArrayList.add(GenreItem("Horror", R.drawable.horror))
        return GenresArrayList
    }
    private fun showGenres(genres: List<GenreItem>) {
        genresRecyclerView.layoutManager = LinearLayoutManager(this)
        genresRecyclerView.adapter = GenreAdapter(genres)
    }
}