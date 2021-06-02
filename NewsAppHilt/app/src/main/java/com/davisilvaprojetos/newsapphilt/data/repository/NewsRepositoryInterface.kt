package com.davisilvaprojetos.newsapphilt.data.repository

import com.davisilvaprojetos.newsapphilt.data.model.NewsResult

interface NewsRepositoryInterface {

    suspend fun getNews(): NewsResult
}