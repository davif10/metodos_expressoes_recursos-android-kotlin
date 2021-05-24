package com.davisilvaprojetos.metodosexpressoeserecursos.ui.main

class MainRepository {

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
}