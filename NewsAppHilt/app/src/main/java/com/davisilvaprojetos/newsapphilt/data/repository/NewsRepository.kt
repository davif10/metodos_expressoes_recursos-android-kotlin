package com.davisilvaprojetos.newsapphilt.data.repository

import android.content.Context
import com.davisilvaprojetos.newsapphilt.data.model.NewsResult
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NewsRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val newsDbDataSource: NewsDbDataSource,
    private val newsApiDataSource: NewsApiDataSource
) : NewsRepositoryInterface {

    override suspend fun getNews(): NewsResult {
        return newsApiDataSource.fetchNews()
    }
}