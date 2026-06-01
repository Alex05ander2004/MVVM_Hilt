package com.example.newsapp.data.model

data class Article(
    val id: Int,
    val source: String,
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)