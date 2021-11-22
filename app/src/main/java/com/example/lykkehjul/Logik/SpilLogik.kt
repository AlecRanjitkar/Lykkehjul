package com.example.lykkehjul.Logik

object SpilLogik {


    fun bogstavToGæt(gætBogstav: String, hemmeligtOrd: String, userIndtastBogstav: String): CharArray {
        // gætBogstav laves om til char
        val gætBogstavArray: CharArray = gætBogstav.toCharArray()
        var index = 0

        while (index < hemmeligtOrd.length) {
            if (hemmeligtOrd.get(index) == userIndtastBogstav.get(0)) {
                gætBogstavArray[index] = userIndtastBogstav.get(0)
            }
            index++
        }
        return gætBogstavArray
    }

    fun erBogstavIHemmeligtOrd(hemmeligtOrd: String, userIndtastBogstav: String): Boolean {
        return hemmeligtOrd.contains(userIndtastBogstav)
    }
    fun multiplyBogstaver(gætBogstav: String, userIndtastBogstav: String) : Int {
        var counter = 0
        for (i in gætBogstav){
            if (i == userIndtastBogstav.get(0)){
                counter++
            }
        }

        return counter
    }



}
