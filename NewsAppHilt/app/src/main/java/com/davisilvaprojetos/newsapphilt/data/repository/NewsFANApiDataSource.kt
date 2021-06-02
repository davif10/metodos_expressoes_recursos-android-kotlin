package com.davisilvaprojetos.newsapphilt.data.repository

import com.davisilvaprojetos.newsapphilt.data.model.NewsResponse
import com.davisilvaprojetos.newsapphilt.data.model.NewsResult
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlin.coroutines.suspendCoroutine

class NewsFANApiDataSource : NewsApiDataSource {

    override suspend fun fetchNews(): NewsResult {
        return suspendCoroutine { continuation ->
            AndroidNetworking.get("https://newsapi.org/v2/top-headlines?country=br")
                .addQueryParameter("category", "technology")
                //.addQueryParameter("apiKey", BuildConfig.NEWS_API_KEY)
                .build()
                .getAsObject(
                    NewsResponse::class.java,
                    object : ParsedRequestListener<NewsResponse> {
                        override fun onResponse(response: NewsResponse?) {
                            response?.let {
                                continuation.resumeWith(Result.success(NewsResult.Success(it.articles)))
                            }
                        }

                        override fun onError(anError: ANError?) {
                            continuation.resumeWith(Result.failure(Throwable("Unknown error")))
                        }
                    })
        }
    }
}