package com.example.lykkehjul.Data

import com.example.lykkehjul.Model.Ord

class Datasource {

    fun loadOrd(): List<Ord>{
        return listOf<Ord>(
            Ord("Tiger"),
            Ord("Falk"),
            Ord("Elefant"),
            Ord("Flodhest"),
            Ord("Dromedar"),
            Ord("Sommerfugl"),
            Ord("Krokodille"),
            Ord("Gepard"),)
    }

    fun loadpoint(): List<Ord>{
        return listOf<Ord>(
        Ord("10"),
        Ord("100"),
        Ord("500"),
        Ord("1000"),
        Ord("1500"),
        Ord("Ekstra tur"),
        Ord("Tabt Tur"),
        Ord("Konkurs"))


    }

}