package com.example.sorteio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.security.SecureRandom


class MainActivity : AppCompatActivity() {

    private val nameList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        /*
            Ao clicar no botão "Sortear" é escolhido um numero randomicamente
         */
        btnSortear.setOnClickListener {

            val secureRandom = SecureRandom()
            println("1 ---- $secureRandom")
            val randomName = secureRandom.nextInt(nameList.count())
            println("2 ------ $randomName")
            selectedNameTxt.text = nameList[randomName] //o numero escolhido é a posicao do nome na lista

        }

        /*
            Ao clicar no botão Adicionar é inserido o nome escrito no campo "Nome"
         */
        btnAddName.setOnClickListener {
            val newName = addNameTxt.text.toString()
            nameList.add(newName)   //Adiciona o nome na lista

            if(newName.isNotEmpty()) { //Verifica se a lista esta vazia, caso esteja aparece uma msg informando e nao é inserido na lista.

                nameList.add(newName)
                Toast.makeText(applicationContext, newName+" foi adicionado com SUCESSO!!", Toast.LENGTH_SHORT).show()
                addNameTxt.text.clear()

            }else{

                Toast.makeText(applicationContext, "O campo Nome esta vazio!!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
