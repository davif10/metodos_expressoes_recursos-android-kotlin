package com.davisilvaprojetos.newsapphilt.data.repository

import com.davisilvaprojetos.newsapphilt.data.model.NewsResult

interface NewsApiDataSource {

    suspend fun fetchNews(): NewsResult
}