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
import com.example.quzzflags.model.Question

class QuizzActivity : AppCompatActivity() {
    private var currentQuestionIndex = 0
    private lateinit var quizzQuestions :List<Question>;

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
        //val quizQuestions = Datas.items
        quizzQuestions = Datas.items

        if (quizzQuestions.isNotEmpty()) {
            showQuestion(currentQuestionIndex)
        } else {
            findViewById<TextView>(R.id.textView).text = "Aucune question disponible."
        }

        // Afficher la première question
        showQuestion(currentQuestionIndex)

        // Accéder à la première question
        //val firstQuestion = quizQuestions[1]


        //gere les clics sur les buttons de réponse
        findViewById<Button>(R.id.option1Button).setOnClickListener {
            checkAnswer(0)
        }
        findViewById<Button>(R.id.option2Button).setOnClickListener {
            checkAnswer(1)
        }
        findViewById<Button>(R.id.option3Button).setOnClickListener {
            checkAnswer(2)
        }
        findViewById<Button>(R.id.option4Button).setOnClickListener {
            checkAnswer(3)
        }

        // Afficher le drapeau
        //findViewById<ImageView>(R.id.imgFlag).setImageResource(firstQuestion.flag)

        // Afficher les quatre réponses dans les boutons
        /*findViewById<Button>(R.id.option1Button).text = firstQuestion.answers[0]
        findViewById<Button>(R.id.option2Button).text = firstQuestion.answers[1]
        findViewById<Button>(R.id.option3Button).text = firstQuestion.answers[2]
        findViewById<Button>(R.id.option4Button).text = firstQuestion.answers[3]
        */

    }
// fonction qui affiche une question en fonction de index
    private fun showQuestion(index: Int) {
        val question = quizzQuestions[index]

        // On Affche le drapeau
        findViewById<ImageView>(R.id.imgFlag).setImageResource(question.flag)

        // Afficher les quatres réponses
        findViewById<Button>(R.id.option1Button).text = question.answers[0]
        findViewById<Button>(R.id.option2Button).text = question.answers[1]
        findViewById<Button>(R.id.option3Button).text = question.answers[2]
        findViewById<Button>(R.id.option4Button).text = question.answers[3]

        // Vide  le message de reponse
        //findViewById<TextView>(R.id.textView).text = ""
    }

    // foncton pour verifier la reponse selectonnée
    private fun checkAnswer(selectedIndex: Int){
        val currentQuestion = quizzQuestions[currentQuestionIndex]
        if(selectedIndex == currentQuestion.index){
            findViewById<TextView>(R.id.textView).text = "Bonne reponse"
        }else{
            findViewById<TextView>(R.id.textView).text = "Mauvaise reponse"
        }

        //Passer à la question suivante
        currentQuestionIndex++

        if (currentQuestionIndex < quizzQuestions.size){
            // afficher la question suivante
            showQuestion(currentQuestionIndex)
        }else{
            //afficher un message de fin de quizz
            findViewById<TextView>(R.id.textView).text = "Fin du quizz"
        }



    }
}