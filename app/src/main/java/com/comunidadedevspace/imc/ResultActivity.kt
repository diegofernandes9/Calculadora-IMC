package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0.0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String
        val cor: Int
            if (result <= 18.5f)  {
                classificacao = "MAGREZA"
                cor = ContextCompat.getColor(this, R.color.roxo_primario)
            } else if (result > 18.5f && result <= 24.9f) {
                classificacao = "NORMAL"
                cor = ContextCompat.getColor(this, R.color.verde_classificacao)
            } else if (result > 25f && result <= 29.9f) {
                classificacao = "SOBREPESO"
                cor = ContextCompat.getColor(this, R.color.amarelo_classificacao)
            } else if (result > 30f && result <= 39.9f) {
                classificacao = "OBESIDADE"
                cor = ContextCompat.getColor(this, R.color.vermelho_classificacao)
            } else {
                classificacao = "OBESIDADE GRAVE"
                cor = ContextCompat.getColor(this, R.color.vinho_classificacao)
            }

                    tvClassificacao . text = classificacao
                    tvClassificacao.setTextColor(cor)
        }
    }