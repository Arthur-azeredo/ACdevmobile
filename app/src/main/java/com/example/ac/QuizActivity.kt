package com.example.ac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val edtName = findViewById<EditText>(R.id.edtName)
        val rgQuestion = findViewById<RadioGroup>(R.id.rgQuestion)
        val btnResult = findViewById<Button>(R.id.btnResult)

        btnResult.setOnClickListener {
            val selectedId = rgQuestion.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Escolha uma opção!", Toast.LENGTH_SHORT).show()
            } else {
                val answer = findViewById<RadioButton>(selectedId).text.toString()
                val name = edtName.text.toString()
                val hero = when (answer) {
                    "Inteligência e tecnologia" -> "Homem de Ferro"
                    "Força e resistência" -> "Hulk"
                    "Velocidade e coragem" -> "Flash"
                    else -> "Capitão América"
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("hero", hero)
                startActivity(intent)
            }
        }
    }
}
