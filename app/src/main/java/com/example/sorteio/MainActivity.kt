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

        // Ao clicar no botão Trocar a cor de fundo
        btnChangeColor.setOnClickListener {
            getTimeNow()
        }
        // Ao clicar no botão SORTEAR!!
        btnSortear.setOnClickListener {
            sortearNumero()
        }
        // Ao clicar no botao Adicionar
        btnAddName.setOnClickListener {
            AddNameLista()

        }
    }


    /*Funcão que adiciona o nome na lista*/
    private fun AddNameLista() {
        val newName = addNameTxt.text.toString()
        nameList.add(newName)   // Adiciona o nome na lista

        // Verifica se a lista esta vazia, caso esteja aparece uma msg informando, e nao é inserido na lista.
        if (newName.isNotEmpty()) {
            nameList.add(newName)
            Toast.makeText(applicationContext, newName + " foi adicionado com SUCESSO!!", Toast.LENGTH_SHORT).show()
            addNameTxt.text.clear()

        } else {

            Toast.makeText(applicationContext, "O campo Nome esta vazio!!", Toast.LENGTH_SHORT).show()
        }
    }

    /*Função para sortear o ganhador*/
    private fun sortearNumero() {
        /*Primeiro verifica se a lista esta vazia*/
        if (nameList.isNotEmpty()) {
            val secureRandom = SecureRandom()
            val randomName = secureRandom.nextInt(nameList.count())
            selectedNameTxt.text = nameList[randomName] // O numero escolhido é a posicao do nome na lista
        } else {
            Toast.makeText(applicationContext, "A LISTA DE NOMES ESTA VAZIA!!", Toast.LENGTH_SHORT).show()
        }

    }

    /*Funcao que pega o tempo Atual*/
    private fun getTimeNow() {
        val now = LocalDateTime.now() // Variavel now recebe o tempo atual
        val number: Int =
            now.toString().takeLast(1).toInt()  // Variavel number recebe apenas o valor da ultima posicao da variavel
        val corChange =
            findColor(number)   // Variavel corChange recebe o resultado da cor associada ao numero obtido pela variavel number
        changeBackgroundColor(corChange)           // Chama a função que altera a cor do Background

    }


    /*Função para alterar a cor do Background*/
    private fun changeBackgroundColor(corChange: String) {
        backGround.setBackgroundColor(Color.parseColor(corChange))
    }

    /*Função que retorna a cor relacionada ao número*/
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
