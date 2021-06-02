package com.davisilvaprojetos.newsapphilt.data.repository

import android.content.Context
import com.davisilvaprojetos.newsapphilt.data.model.NewsResult

class NewsRepository(
    private val context: Context,
    private val newsDbDataSource: NewsDbDataSource,
    private val newsApiDataSource: NewsApiDataSource
) : NewsRepositoryInterface {

    override suspend fun getNews(): NewsResult {
        return newsApiDataSource.fetchNews()
    }
}