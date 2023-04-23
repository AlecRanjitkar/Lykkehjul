package com.example.lykkehjul.Logik

object SpilLogik {


    fun bogstavToGæt(gætBogstav: String, hemmeligtOrd: String, userIndtastBogstav: String): CharArray {
        val gætBogstavArray: CharArray = gætBogstav.toCharArray()
        var index = 0

        while (index < hemmeligtOrd.length) {
            if (hemmeligtOrd.get(index) == userIndtastBogstav.get(0)) {
                gætBogstavArray[index] = userIndtastBogstav.get(0)
            }
            index++
        }
        //returnere en char array som indeholder den opdateret version af input-strengen gætBogstav
        // hvori user indtastet bogstav i strengen hemmeligtord er blevet erstattet med samme bogstav
        return gætBogstavArray
    }

    fun erBogstavIHemmeligtOrd(hemmeligtOrd: String, userIndtastBogstav: String): Boolean {
        //returnere true eller false kommer an på userIndstastBogstav er en del af det hemmelig ord
        return hemmeligtOrd.contains(userIndtastBogstav)
    }
    fun antalGættetBogstavIHemmeligeOrd(gætBogstav: String, userIndtastBogstav: String) : Int {
        var counter = 0
        for (i in gætBogstav){
            if (i == userIndtastBogstav.get(0)){
                counter++
            }
        }
        // returner hvor mange elementer i gætbogstav som er det samme som det indtastet bogstav
        return counter
    }



}
