package com.example.lykkehjul.Model

import com.example.lykkehjul.Model.Ord

//Brugt til at give adgang til data
class Datasource {

    fun loadOrd(): List<Ord>{
        return listOf<Ord>(
            Ord("bayern munichen"),
            Ord("juventus"),
            Ord("ac milan"),
            Ord("dortmund"),
            Ord("real madrid"),
            Ord("chelsea"),
            Ord("barcelona"),
            Ord("manchester city"),
            Ord("arsenal"))
    }

    fun loadpoint(): List<Ord>{
        return listOf<Ord>(
            Ord("10"),
            Ord("10"),
            Ord("10"),
            Ord("10"),
            Ord("10"),
            Ord("100"),
            Ord("100"),
            Ord("100"),
            Ord("100"),
            Ord("500"),
            Ord("500"),
            Ord("500"),
            Ord("1000"),
            Ord("1000"),
            Ord("1500"),
            Ord("Ekstra liv"),
            Ord("Tabt liv"),
            Ord("Konkurs"),)


    }

}