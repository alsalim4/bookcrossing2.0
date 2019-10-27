package com.example.bookcrossing.entities

import com.example.bookcrossing.entities.Book

data class BooksListRespose(
    var code: Int?,
    var books: List<Book>?
)