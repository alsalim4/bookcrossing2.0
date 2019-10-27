package com.example.bookcrossing.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrossing.MenuActivity
import com.example.bookcrossing.R
import com.example.bookcrossing.entities.Book
import com.example.bookcrossing.genre_list.GenreListActivity
import kotlinx.android.synthetic.main.activity_book.*


class HomeFragment : Fragment(), GenresAdapter.OnItemClickListener, AllBooksAdapter.OnItemClickListener {
    override fun onBookItemClicked(item: Book) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var genreList = ArrayList<GenreItem>()
    var freeBooksAdapter: AllBooksAdapter? = null
    var genresAdapter: GenresAdapter? = null
    var recommendedAdapter: AllBooksAdapter? = null
    var allBooksAdapter: AllBooksAdapter? = null


    override fun onGenreItemClicked(item: GenreItem) {
        val tmpIntent = Intent(activity, GenreListActivity::class.java)
        tmpIntent.putExtra(GenreListActivity.KEY_GENRE, item.name)
        startActivity(tmpIntent)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        genreList.apply {
            add(GenreItem("Romance", R.drawable.rrr))
            add(GenreItem("Science", R.drawable.sss))
            add(GenreItem("Fiction", R.drawable.fff))
            add(GenreItem("Detective", R.drawable.detective))
            add(GenreItem("Drama", R.drawable.drama))
            add(GenreItem("Novel", R.drawable.novel))
            add(GenreItem("Mystery", R.drawable.mystery))
            add(GenreItem("Fantasy", R.drawable.fantasy))
            add(GenreItem("Thriller", R.drawable.thriller))
            add(GenreItem("History", R.drawable.history))
            add(GenreItem("Horror", R.drawable.horror))
        }
        return inflater.inflate(com.example.bookcrossing.R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        freeBooksAdapter = AllBooksAdapter(activity as MenuActivity, this@HomeFragment)
        genresAdapter = GenresAdapter(genreList, this@HomeFragment)
        recommendedAdapter = AllBooksAdapter(activity as MenuActivity, this@HomeFragment)
        allBooksAdapter = AllBooksAdapter(activity as MenuActivity, this@HomeFragment)


    }
}