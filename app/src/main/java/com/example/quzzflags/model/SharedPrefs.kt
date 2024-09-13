package com.example.quzzflags.model

import android.content.Context

class SharedPrefs(context: Context) {
    private val scoreKey = "scoreKey"
    private val repo = "ScoreRepo"
    private val mode = Context.MODE_PRIVATE
    private val shared = context.getSharedPreferences(repo, mode)

    var score: Int
        get() = shared.getInt(scoreKey, 0)
        set(value) {
            shared.edit().putInt(scoreKey, value).apply()
        }
}
