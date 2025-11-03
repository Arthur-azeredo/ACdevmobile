package com.example.ac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("name")
        val hero = intent.getStringExtra("hero")

        val txtResult = findViewById<TextView>(R.id.txtResult)
        val imgHero = findViewById<ImageView>(R.id.imgResult)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnRetry = findViewById<Button>(R.id.btnRetry) // novo botão

        txtResult.text = "$name, você se parece com o $hero!"

        val imageRes = when (hero) {
            "Homem de Ferro" -> R.drawable.ironman
            "Hulk" -> R.drawable.hulk
            "Flash" -> R.drawable.flash
            else -> R.drawable.capitaoamerica
        }
        imgHero.setImageResource(imageRes)

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Eu sou como o $hero! Descubra o seu também!")
            startActivity(Intent.createChooser(shareIntent, "Compartilhar resultado"))
        }

        btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
