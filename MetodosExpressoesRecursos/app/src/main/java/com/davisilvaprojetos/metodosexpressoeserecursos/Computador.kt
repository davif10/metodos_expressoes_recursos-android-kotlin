package com.davisilvaprojetos.metodosexpressoeserecursos

class Computador : Maquina{
    override fun ligar(): String{
        println("Máquina Ligada")
        return "Máquina Ligada"
    }

    override fun desligar() : String{
        println("Máquina Desligada")
        return "Máquina Desligada"
    }
}