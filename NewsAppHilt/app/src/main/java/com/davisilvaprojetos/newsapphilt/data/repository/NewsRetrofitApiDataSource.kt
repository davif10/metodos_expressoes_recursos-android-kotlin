package com.davisilvaprojetos.newsapphilt.data.repository

import com.davisilvaprojetos.newsapphilt.data.NewsApiClient
import com.davisilvaprojetos.newsapphilt.data.model.NewsResult
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class NewsRetrofitApiDataSource @Inject constructor(
    private val newsApiClient: NewsApiClient
) : NewsApiDataSource {

    override suspend fun fetchNews(): NewsResult {
        return when (val newsResponse = newsApiClient.getNews()) {
            is NetworkResponse.Success -> {
                val articles = newsResponse.body.articles
                NewsResult.Success(articles)
            }
            is NetworkResponse.ServerError -> {
                NewsResult.ApiError(newsResponse.code, newsResponse.body?.message)
            }
            else -> NewsResult.UnknownError("Unknown error")
        }
    }
}