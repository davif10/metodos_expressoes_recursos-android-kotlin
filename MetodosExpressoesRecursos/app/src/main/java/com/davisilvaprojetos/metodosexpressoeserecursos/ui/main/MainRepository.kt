package com.davisilvaprojetos.metodosexpressoeserecursos.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

open class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit){
         Thread(Runnable{
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1,"Título 1"),
                    Filme(2,"Título 2"),
                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filme>{
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Filme(1,"Título 1"),
                Filme(2,"Título 2"),
            )
        }
    }
}