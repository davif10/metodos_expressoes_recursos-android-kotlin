package com.davisilvaprojetos.metodosexpressoeserecursos

//Limita a classe SealedClass apenas dentro desse arquivo, outras classes fora não podem herdar dela
sealed class SealedClass {
    class Success(val message: String): SealedClass()
    class Error(val message: String, val errorCode: Int): SealedClass()
}

class Repo{
    fun execute(): SealedClass{
        return SealedClass.Success("Sucesso")
    }
}