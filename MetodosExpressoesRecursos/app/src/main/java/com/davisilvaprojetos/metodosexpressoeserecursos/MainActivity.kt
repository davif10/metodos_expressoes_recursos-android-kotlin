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
            if(click){
                textTest.text = computer.ligar()
                click = false
            }else{
                textTest.text = computer.desligar()
                click = true
            }
        }

        val lf = LambdaFunction()
        val l1 : (Int, Int) -> Int = {num1 , num2 -> num1+num2}
        val valor = lf.somando(6,10, l1)
        println("VALOR: $valor")
    }
}