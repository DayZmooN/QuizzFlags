package com.example.quzzflags.datas

import com.example.quzzflags.R
import com.example.quzzflags.model.Question

object Datas {


    val france = Question(flag = R.drawable.fr, answers = listOf("France","Italie","Luxembourg", "Irlande"),  index = 0)
    val belgique = Question(flag = R.drawable.be, answers = listOf("Allemagne", "Autriche", "Cameroun", "Belgique"),  index = 3)
    val finlande = Question(flag = R.drawable.fi, answers = listOf("Suède", "Finlande","Islande","Norvège"),  index = 1)
    val grece = Question(flag = R.drawable.gr, answers = listOf("Australie", "Etats-Unis","Grèce","Paraguay"),  index = 2)
    val japon = Question(flag = R.drawable.jp, answers = listOf("Japon", "Chine","Corée du Nord","Thailande"),  index = 0)
    val mexique = Question(flag = R.drawable.mx, answers = listOf("Irlande", "Mexique","Italie","Portugal"),  index = 1)
    val paysBas = Question(flag = R.drawable.nl, answers = listOf("France", "Serbie","Pays-Bas", "Croatie"),  index = 2)
    val portugal = Question(flag = R.drawable.pt, answers = listOf("Namibie", "Ukraine","Iran", "Portugal"),  index = 3)
    val tunisie = Question(flag = R.drawable.tn, answers = listOf("Tunisie", "Turquie","Maroc","Algérie"),  index = 0)
    val uruguay = Question(flag = R.drawable.uy, answers = listOf("Argentine", "uruguay", "Paraguay","Chili"),  index = 1)

    val items = listOf<Question>(france, belgique, finlande, grece, japon, mexique, paysBas, portugal, tunisie, uruguay)

}