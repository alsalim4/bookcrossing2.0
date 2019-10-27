package com.example.bookcrossing.entities

import com.example.bookcrossing.entities.BookComment

data class BookCommentResponse (
    var code: Int?,
    var comment: BookComment?
)