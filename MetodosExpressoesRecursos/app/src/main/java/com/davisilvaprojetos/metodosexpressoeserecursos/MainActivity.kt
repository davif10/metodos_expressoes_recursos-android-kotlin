package com.davisilvaprojetos.metodosexpressoeserecursos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val nl =  Nullability()
        val texto = nl.retorno("null","TESTE")
         textTest.text = texto*/
        val computer = Computador()
        var click = true
        textTest.setOnClickListener {
            if (click) {
                textTest.text = computer.ligar()
                click = false
            } else {
                textTest.text = computer.desligar()
                click = true
            }
        }

        val lf = LambdaFunction()
        val l1: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
        val valor = lf.somando(6, 10, l1)
        println("VALOR: $valor")

        //Função anônima (Função sem nome)
        operator(20, 10, fun(a: Int, b: Int): Int {
            return a * b
        })


        val r1 = Repo()
        val result : SealedClass = r1.execute()
        when(result){
            is SealedClass.Success -> {println("Deu Sucesso")}
            is SealedClass.Error -> {println("Deu erro!")}
        }
    }

    fun operator(x: Int, y: Int, op: (Int, Int) -> Int): Int {
        val ret = op(x, y)
        println("RET VALOR: $ret")
        return ret
    }
}