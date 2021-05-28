package com.davisilvaprojetos.metodosexpressoeserecursos

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.davisilvaprojetos.metodosexpressoeserecursos.ui.main.Filme
import com.davisilvaprojetos.metodosexpressoeserecursos.ui.main.MainRepository
import com.davisilvaprojetos.metodosexpressoeserecursos.ui.main.MainViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmesLiveDataObserver: Observer<List<Filme>>

    private lateinit var viewModel: MainViewModel

    @Test
    fun `quando viewModel receber os filmes então setar no filmesLiveData`(){

        //Cenario
        val filmes = listOf(
            Filme(1,"Título 1"),
            Filme(2,"Título 2"),
        )

        val resultSuccess =

        //Acao
        viewModel.getFilmesCoroutines()
        //Verificacao
    }

}

