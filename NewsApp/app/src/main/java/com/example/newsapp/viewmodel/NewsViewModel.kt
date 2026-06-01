package com.example.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(val articles: List<Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        loadTopHeadlines()
    }

    fun loadTopHeadlines() {
        _uiState.value = NewsUiState.Success(repository.getTopHeadlines())
    }

    fun searchNews(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            loadTopHeadlines()
            return
        }
        val results = repository.searchNews(query)
        _uiState.value = if (results.isEmpty()) {
            NewsUiState.Error("No se encontraron noticias para \"$query\"")
        } else {
            NewsUiState.Success(results)
        }
    }
}