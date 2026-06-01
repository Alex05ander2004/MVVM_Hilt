package com.example.newsapp.data.remote

import com.example.newsapp.data.model.Article

// Respuesta que devuelve la API de NewsAPI.org
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)