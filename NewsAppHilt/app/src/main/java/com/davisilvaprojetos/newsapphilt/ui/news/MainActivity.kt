package com.davisilvaprojetos.newsapphilt.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davisilvaprojetos.newsapphilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}