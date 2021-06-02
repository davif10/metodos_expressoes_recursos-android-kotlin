package com.davisilvaprojetos.newsapphilt.data

import com.davisilvaprojetos.newsapphilt.BuildConfig
import com.davisilvaprojetos.newsapphilt.data.model.ErrorResponse
import com.davisilvaprojetos.newsapphilt.data.model.NewsResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiClient {

    @GET("top-headlines?country=br")
    suspend fun getNews(
        @Query("category") category: String = "technology",
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): NetworkResponse<NewsResponse, ErrorResponse>
}