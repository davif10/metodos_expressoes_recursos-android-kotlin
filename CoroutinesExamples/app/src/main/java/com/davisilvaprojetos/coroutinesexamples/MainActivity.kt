package com.davisilvaprojetos.coroutinesexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
/*
    fun GFG()
    {
        var resultOne = "Android"
        var resultTwo = "Kotlin"
        Log.i("Launch", "Before")
        launch(Dispatchers.IO) { resultOne = function1() }
        launch(Dispatchers.IO) { resultTwo = function2() }
        Log.i("Launch", "After")
        val resultText = resultOne + resultTwo
        Log.i("Launch", resultText)
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
*/
}
