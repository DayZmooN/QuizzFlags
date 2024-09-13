package com.example.quzzflags

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quzzflags.datas.Datas

class QuizzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Accéder à la liste des questions
        val quizQuestions = Datas.items

        // Accéder à la première question
        val firstQuestion = quizQuestions[0]

        // Afficher le drapeau
        findViewById<ImageView>(R.id.imgFlag).setImageResource(firstQuestion.flag)

        // Afficher les quatre réponses dans les boutons
        findViewById<Button>(R.id.option1Button).text = firstQuestion.answers[0]
        findViewById<Button>(R.id.option2Button).text = firstQuestion.answers[1]
        findViewById<Button>(R.id.option3Button).text = firstQuestion.answers[2]
        findViewById<Button>(R.id.option4Button).text = firstQuestion.answers[3]
    }
}