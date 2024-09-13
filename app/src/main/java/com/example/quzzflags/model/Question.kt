package com.example.quzzflags.model

import androidx.annotation.DrawableRes

data class Question(@DrawableRes val flag:Int,val answers:List<String>,val index:Int) {

}