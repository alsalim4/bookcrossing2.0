package com.example.bookcrossing.entities

data class User(
    var id: String? = null,
    var name: String? = null,
    var username: String? = null,
    var password: String? = null,
    var photo: Int? =null
){
    constructor() : this(null, null, null,null)
}