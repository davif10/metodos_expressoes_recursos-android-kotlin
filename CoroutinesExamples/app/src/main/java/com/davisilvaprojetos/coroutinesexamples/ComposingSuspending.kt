package com.davisilvaprojetos.coroutinesexamples

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class ComposingSuspending {

    fun testOne(){
        runBlocking {
            val time = measureTimeMillis {
                val one = doSomethingUsefulOne()
                val two = doSomethingUsefulTwo()
                println("A resposta é ${one + two}")
            }
            println("Completo em $time ms")
        }

    }

    fun testTwo(){
        runBlocking {
            val time = measureTimeMillis {
                val one = async { doSomethingUsefulOne() }
                val two = async { doSomethingUsefulTwo() }
                println("A resposta é ${one.await() + two.await()}")
            }
            println("Completo em $time ms")
        }

    }

    /*Neste modo, ele só inicia o coroutine quando seu resultado
     é exigido por await, ou se sua função start é invocada.

     */
    fun testThree(){
        runBlocking {
            val time = measureTimeMillis {
                val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
                val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
                // some computation
                one.start() // start the first one
                two.start() // start the second one
                println("The answer is ${one.await() + two.await()}")
            }
            println("Completed in $time ms")
        }
    }

    fun testFour(){
        val time = measureTimeMillis {
            //podemos iniciar ações assíncronas fora de uma coroutina
            val one = somethingUsefulOneAsync()
            val two = somethingUsefulTwoAsync()

            // mas esperar por um resultado deve envolver suspensão ou bloqueio.
            // aqui usamos `runBlocking {...}` para bloquear a thread principal enquanto esperamos pelo resultado
            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }
        println("Completed in $time ms")
    }

    // Simultaneidade estruturada com assíncrono
    fun testFive(){
        runBlocking {
            val time = measureTimeMillis {
                println("The answer is ${concurrentSum()}")
            }
            println("Completed in $time ms")
        }

    }

    //O tipo de resultado de somethingUsefulOneAsync é Adiado <Int>
    @OptIn(DelicateCoroutinesApi::class)
    fun somethingUsefulOneAsync() = GlobalScope.async {
        doSomethingUsefulOne()
    }

    //O tipo de resultado de somethingUsefulTwoAsync é Adiado <Int>
    @OptIn(DelicateCoroutinesApi::class)
    fun somethingUsefulTwoAsync() = GlobalScope.async {
        doSomethingUsefulTwo()
    }

    suspend fun doSomethingUsefulOne(): Int {
        delay(1000L) // pretend we are doing something useful here
        return 13
    }

    suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }
    suspend fun concurrentSum(): Int = coroutineScope {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        one.await() + two.await()
    }

}