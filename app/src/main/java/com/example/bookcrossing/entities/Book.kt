package com.example.bookcrossing.entities

import com.example.bookcrossing.home.GenreItem

data class Book(
    var id: Int? = null,
    var name: String? = null,
    var isbn: String? = null,
    var author: String? = null,
    var description: String? = null,
    var photo: String? = null,
    var company_book: Boolean? = false,
    var genre: List<GenreItem>? = null,
    var comments: List<BookComment>? = null,
    var belong: User? = null,
    var reader: User? = null,
    var reader_int: Int? = null,
    var history: List<User>? = null,
    var rating: Float? = null,
    var requesters: List<Int>? = null
)

