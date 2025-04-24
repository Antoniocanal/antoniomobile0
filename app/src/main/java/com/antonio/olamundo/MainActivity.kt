package com.antonio.olamundo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.antonio.olamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var idade: EditText
    private lateinit var escolha: Spinner
    private lateinit var textoFinal: TextView
    private var resultado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idade = binding.editTextText5
        escolha = binding.spinner4
        textoFinal = binding.textView3

        val dados = listOf("Homem", "Mulher")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner4.adapter = adapter

        binding.button5.setOnClickListener {
            val idadeString = idade.text.toString()

            if (idadeString.isNotEmpty()) {
                val idadeInt = idadeString.toInt()
                val escolhaSexo = escolha.selectedItem.toString()

                when (escolhaSexo) {
                    "Homem" -> {
                        if (idadeInt < 65) {
                            resultado = 65 - idadeInt
                            textoFinal.text = "Faltam $resultado anos para se aposentar"
                        } else {
                            textoFinal.text = "Você já tem idade suficiente para se aposentar"
                        }
                    }
                    "Mulher" -> {
                        if (idadeInt < 62) {
                            resultado = 62 - idadeInt
                            textoFinal.text = "Faltam $resultado anos para se aposentar"
                        } else {
                            textoFinal.text = "Você já tem idade suficiente para se aposentar"
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Por favor, insira a idade", Toast.LENGTH_SHORT).show()
            }
        }
    }
}