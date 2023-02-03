package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* IMC table data
        Menor 18.5 Abaixo do Peso 0
        Entre 18.5 E 24.9 Normal 0
        Entre 25.0 E 29.9 Sobrepeso I
        Entre 30.0 E 39.9 Obesidade II
        Maior 40.0 Obesidade grave III
         */

        val classificacao = if (result < 18.5f) {
            "UNDERWEIGHT"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25f..29.9f) {
            "OVERWEIGHT"
        } else if (result in 30f..39.9f) {
            "OBESE"
        } else {
            "EXTREMELY OBESE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}