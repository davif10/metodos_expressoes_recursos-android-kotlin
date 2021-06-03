package com.davisilvaprojetos.newsapphilt.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davisilvaprojetos.newsapphilt.data.repository.NewsFANApiDataSource
import com.davisilvaprojetos.newsapphilt.data.repository.NewsDbDataSource
import com.davisilvaprojetos.newsapphilt.data.repository.NewsRepository
import com.davisilvaprojetos.newsapphilt.R
import com.davisilvaprojetos.newsapphilt.data.WebApiAccess
import com.davisilvaprojetos.newsapphilt.data.repository.NewsRetrofitApiDataSource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.main_fragment) {
    private val viewModelHilt: NewsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelHilt.articlesEvent.observe(viewLifecycleOwner, Observer {
            with(recyclerArticles) {
                setHasFixedSize(true)
                adapter = NewsAdapter(it)
            }
        })

        viewModelHilt.getNews()
    }

}
