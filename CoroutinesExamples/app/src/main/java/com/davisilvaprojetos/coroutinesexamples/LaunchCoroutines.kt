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
    }

    fun testFour() = runBlocking {
        val job = launch {
            delay(1000L)
            println("World")
        }
        println("Hello")
        job.join()//Espera até que a Coroutine seja concluída
        println("FINISH")
    }

    fun testFive() = runBlocking {
        repeat(100_000){
            launch {
                delay(5000L)
                print("*")
            }
        }
    }

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