package com.davisilvaprojetos.coroutinesexamples

import android.util.Log
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*

class AsyncCoroutines {
    //Async faz com que as chamadas sejam realizadas em paralelo
    fun GFG() {
        runBlocking {
            Log.i("Async", "Before")
            val resultOne = async (Dispatchers.IO){ function1() }
            val resultTwo = async(Dispatchers.IO) { function2() }
            Log.i("Async", "After")
            val resultText = resultOne.await() + resultTwo.await()
            Log.i("Async", resultText)
        }

    }

    suspend fun function1(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Async", message)
        return message
    }

    suspend fun function2(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Async", message)
        return message
    }
}