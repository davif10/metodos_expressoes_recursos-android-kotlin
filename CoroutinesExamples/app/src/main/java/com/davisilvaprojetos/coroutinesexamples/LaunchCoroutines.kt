package com.davisilvaprojetos.coroutinesexamples

import android.util.Log
import kotlinx.coroutines.*

class LaunchCoroutines {

    fun testOne() {
        var resultOne = "Android"
        var resultTwo = "Kotlin"
        Log.i("Launch TestOne", "Before")
        //runBlocking bloqueia a Thread principal até que todos os coroutines dentro completa a execução
        runBlocking {
            launch(Dispatchers.IO) { resultOne = function1() }
            launch(Dispatchers.IO) { resultTwo = function2() }
        }

        Log.i("Launch", "After")
        val resultText = resultOne + resultTwo
        Log.i("Launch ", resultText)
    }

    fun testTwo() = runBlocking {
        Log.i("Launch TestTwo", "Before")
        var resultOne = "Android"
        var resultTwo = "Kotlin"

        launch {
            resultOne = function1()
            resultTwo = function2()
        }
        Log.i("Launch", "After")
        val resultText = resultOne + resultTwo
        Log.i("Launch", resultText)
    }

    fun testThree() = runBlocking {
        doWorld()
        println("Finish testThree")
        println("-------------------------------------")
    }

    fun testFour() = runBlocking {
        val job = launch {
            delay(1000L)
            println("World")
        }
        println("Hello")
        job.join()//Espera até que a Coroutine seja concluída
        println("FINISH")
        println("-------------------------------------")
    }

    fun testFive() = runBlocking {
        repeat(100_000){
            launch {
                delay(5000L)
                print("*")
            }
        }
    }

    fun testSix() = runBlocking {
        val job  = launch {
            repeat(1000){
                println("JOB: Dormindo $it ...")
                delay(500L)
            }
        }

        delay(1300L)
        println("Main: Cansei de esperar!")
        job.cancel() //Cancela  o Job
        job.join() //Aguarda o Job ser completado
        println("main: Agora posso sair")
        println("-------------------------------------")
    }

    //Tornando o código de computação cancelável
    fun testSeven() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch (Dispatchers.Default){
            var nextPrintTime = startTime
            var i = 0
            while(isActive){
                // loop de computação cancelável
                // imprime uma mensagem duas vezes por segundo
                if(System.currentTimeMillis() >= nextPrintTime){
                    println("job: Dormindo ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("Main: Cansei de esperar!")
        job.cancelAndJoin() //Cancela o Job e espera completar
        println("Main: Agora posso sair")
        println("-------------------------------------")
    }

    fun testEight() = runBlocking {
        val job  = launch {
            try {
                repeat(1000){
                    println("JOB: Dormindo $it ...")
                    delay(500L)
                }

            }finally {
                println("job: Correndo finally")
            }

        }

        delay(1300L)
        println("Main: Cansei de esperar!")
        job.cancelAndJoin()
        println("main: Agora posso sair")
        println("-------------------------------------")
    }


    //Funções suspensas

    suspend fun function1(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Launch", message)
        return message
    }

    suspend fun function2(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Launch", message)
        return message
    }

    suspend fun doWorld() = coroutineScope {
        launch {
            delay(2000L)
            println("World 2")
        }
        launch {
            delay(1000L)
            println("World 1")
        }
        println("Hello")
    }
}