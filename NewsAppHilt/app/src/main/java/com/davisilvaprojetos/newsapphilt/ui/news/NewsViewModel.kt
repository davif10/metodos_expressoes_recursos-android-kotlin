package com.davisilvaprojetos.newsapphilt.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davisilvaprojetos.newsapphilt.data.model.Article
import com.davisilvaprojetos.newsapphilt.data.model.NewsResult
import com.davisilvaprojetos.newsapphilt.data.repository.NewsRepositoryInterface


class NewsViewModel(
    private val newsRepository: NewsRepositoryInterface
) : ViewModel() {

    private val _articlesEvent = MutableLiveData<List<Article>>()
    val articlesEvent: LiveData<List<Article>>
        get() = _articlesEvent

    fun getNews() = viewModelScope.launch {
        when (val newsResult = newsRepository.getNews()) {
            is NewsResult.Success -> {
                _articlesEvent.value = newsResult.articles
            }
            is NewsResult.ApiError -> {
                if (newsResult.code == 401) {
                    // Show screen error
                }
            }
            is NewsResult.UnknownError -> {
                // Show toast
            }
        }
    }
}
