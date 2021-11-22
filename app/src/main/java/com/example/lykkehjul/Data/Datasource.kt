package com.example.lykkehjul.Data

import com.example.lykkehjul.Model.Ord

class Datasource {

    // Liste af ord over Fodboldhold
    fun loadOrd(): List<Ord>{
        return listOf<Ord>(
            //Ord("real madrid"),
            //Ord("chelsea"),
            //Ord("barcelona"),
            Ord("manchester city"),
            //Ord("arsenal"),
            //Ord("bayern munichen"),
            //Ord("juventus"),
            //Ord("ac milan")
            //Ord("dortmund")

             )
    }

    fun loadpoint(): List<Ord>{
        return listOf<Ord>(
            Ord("10"),
            /*Ord("100"),
            Ord("500"),
            Ord("1000"),
            Ord("1500"),
            Ord("Ekstra liv"),
            Ord("Tabt liv"),
            Ord("Konkurs"),
*/

        )


    }

}