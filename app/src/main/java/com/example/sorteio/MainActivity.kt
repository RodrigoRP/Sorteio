package com.example.sorteio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.security.SecureRandom
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    private var nameList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTimeNow()
        btnSortear.setOnClickListener {
            sortearNumero()
        }
        btnAddName.setOnClickListener {
            AddNameLista()

        }
    }


    private fun AddNameLista() {
        var newName = addNameTxt.text.toString()
        nameList.add(newName)   //Adiciona o nome na lista

        if (newName.isNotEmpty()) { //Verifica se a lista esta vazia, caso esteja aparece uma msg informando e nao é inserido na lista.

            nameList.add(newName)
            Toast.makeText(applicationContext, newName + " foi adicionado com SUCESSO!!", Toast.LENGTH_SHORT).show()
            addNameTxt.text.clear()

        } else {

            Toast.makeText(applicationContext, "O campo Nome esta vazio!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sortearNumero() {

        var secureRandom = SecureRandom()
        var randomName = secureRandom.nextInt(nameList.count())
        selectedNameTxt.text = nameList[randomName] //o numero escolhido é a posicao do nome na lista
    }

    private fun getTimeNow() {

        var btnChangeColor: Button = findViewById(R.id.btnChangeColor)
        btnChangeColor.setOnClickListener {
            // Trecho de código é executado apenas ao clicar no botao
            var now = LocalDateTime.now()        // Variavel now recebe o tempo atual
            var number: Int =
                now.toString().takeLast(1)
                    .toInt()  // Variavel number recebe apenas o valor da ultima posicao da variavel
            var corChange =
                findColor(number)   // Variavel corChange recebe o resultado da cor associada ao numero obtido pela variavel number
            changeBackgroundColor(corChange)           // Chama a função que altera a cor do Background
        }
    }


    /*
        Funcao para alterar a cor do Background
    */
    private fun changeBackgroundColor(corChange: String) {
        backGround.setBackgroundColor(Color.parseColor(corChange))
    }

    /*
        Função que retorna a cor relacionada ao numero
    */
    private fun findColor(num: Int): String {
        lateinit var nameOfColor: String
        when (num) {
            0 -> nameOfColor = "WHITE"
            1 -> nameOfColor = "BLACK"
            2 -> nameOfColor = "BLUE"
            3 -> nameOfColor = "GREEN"
            4 -> nameOfColor = "#FFC0CB"
            5 -> nameOfColor = "RED"
            6 -> nameOfColor = "#800080"
            7 -> nameOfColor = "YELLOW"
            8 -> nameOfColor = "GRAY"
            9 -> nameOfColor = "#c8a2c8"
        }
        return nameOfColor

    }
}
