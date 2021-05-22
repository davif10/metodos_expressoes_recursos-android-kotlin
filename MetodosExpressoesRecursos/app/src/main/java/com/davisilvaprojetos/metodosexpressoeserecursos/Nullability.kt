package com.davisilvaprojetos.metodosexpressoeserecursos

class Nullability {
    var numberOne: Int? = null ?: 0
    val numberTwo: Int = 1
    val sum = numberOne?.plus(numberTwo)

    fun retorno(teste1: String?, teste2: String?): String{
        if(teste1.isNullOrEmpty() || teste2.isNullOrEmpty()){
            return "TEM NULO"
        }
        return "NÃO TEM NULO"
    }
}