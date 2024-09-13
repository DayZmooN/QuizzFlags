package com.example.quzzflags

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quzzflags.model.SharedPrefs

class MainActivity : AppCompatActivity() {
    private lateinit var scoreText: TextView
    private lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialiser le textview du  score
        scoreText = findViewById(R.id.scoreText)
        sharedPrefs = SharedPrefs(this)

        // Récupérer le score stocké
        val storedScore = sharedPrefs.score
        scoreText.text = "Score: $storedScore"

        val goPlay = findViewById<Button>(R.id.btn_goplay)
        goPlay.setOnClickListener {
            val intent = Intent(this, QuizzActivity::class.java)
            startActivity(intent)
        }
        
    }

    fun updateScore() {
        scoreText.text = "Score: ${sharedPrefs.score}"
    }


    override fun onResume() {
        super.onResume()
        updateScore()
    }
}