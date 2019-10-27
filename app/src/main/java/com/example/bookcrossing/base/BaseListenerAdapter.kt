package com.example.bookcrossing.base

interface BaseListenerAdapter<T> {
    fun onClick(pos: Int, item: T)
}