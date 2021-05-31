package com.davisilvaprojetos.coroutinesexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val lc = LaunchCoroutines()
        //Algumas formas de utilização da Coroutine Launch
        lc.testOne()
        lc.testTwo()
        lc.testThree()
        lc.testFour()
        lc.testFive()

        //Utilizando cancelamento de uma Coroutine
        lc.testSix()
        lc.testSeven()
        lc.testEight()

        //Tempo limite
        lc.testNine() */

        /*
        //Compondo funções de suspensão
        val cs = ComposingSuspending()
        cs.testOne() //Medir tempo da execução
        cs.testTwo() //Medir tempo usando async
        cs.testThree() //Utilizando Lazy
        cs.testFour()// Utilizando async fora da coroutina
        cs.testFive() // Simultaneidade estruturada com async*/

        val ac = AsyncCoroutines()
        ac.GFG()
    }


}
