package com.example.lykkehjul.Data

import com.example.lykkehjul.Model.Ord

class Datasource {

    fun loadOrd(): List<Ord>{
        return listOf<Ord>(
            Ord("tiger"),
            Ord("falk"),
            Ord("elefant"),
            Ord("flodhest"),
            Ord("dromedar"),
            Ord("sommerfugl"),
            Ord("krokodille"),
            Ord("gepard"))


    }

    fun loadpoint(): List<Ord>{
        return listOf<Ord>(
            Ord("10"),
            Ord("100"),
            Ord("500"),
            Ord("1000"),
            Ord("1500"),
            Ord("Ekstra liv"),
            Ord("Tabt liv"),
            Ord("Konkurs"),


        )


    }

}