package com.davisilvaprojetos.metodosexpressoeserecursos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davisilvaprojetos.metodosexpressoeserecursos.ui.main.FilmesCoroutinesFragment

class FilmesCoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filmes_coroutines_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FilmesCoroutinesFragment.newInstance())
                .commitNow()
        }
    }
}