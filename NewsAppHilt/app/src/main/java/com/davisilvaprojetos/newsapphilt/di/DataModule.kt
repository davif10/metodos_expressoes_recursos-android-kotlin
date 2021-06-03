package com.davisilvaprojetos.newsapphilt.di

import com.davisilvaprojetos.newsapphilt.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindNewsRepository(
        newsRepository: NewsRepository
    ) : NewsRepositoryInterface

    @Singleton
    @Binds
    abstract fun bindApiDataSource(
        //apiDataSource: NewsFANApiDataSource
        apiDataSource: NewsRetrofitApiDataSource
    ) : NewsApiDataSource
}