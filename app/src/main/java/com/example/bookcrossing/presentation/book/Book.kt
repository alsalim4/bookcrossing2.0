package com.example.bookcrossing.presentation.book

import com.example.bookcrossing.entities.User

data class Book(
    var name: String? = null,
    var isbn: String? = null,
    var author: String? = null,
    var description: String? = null,
    var photo: Int? = null,
    //var genre: List<GenreItem>? = null,
    //var owner: User? = null,
    //var reader: User? = null,
    var taken: Boolean?=null,
    var rating: Float? = null
)