package com.davisilvaprojetos.metodosexpressoeserecursos

class LambdaFunction {

    val somar: (Int, Int) -> Int = { one: Int, two: Int -> one + two }
    val menos = { one: Int, two: Int -> one - two }

    val itens = listOf(1, 2, 3, 4, 5)

    fun chamada() {
        var i = itens.size - 1
        while (i > 1) {
            println("SOMAR: ${somar(itens.get(i), itens.get(i - 1))}")
            println("SUBTRAIR: ${menos(itens.get(i), itens.get(i-1))}")
            i--
        }
    }

    fun somando(num1: Int, num2: Int):Int { return num1+num2 }


}