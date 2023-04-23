package com.example.lykkehjul.Model

//Denne klasse repræsenteret et object af ord som har typen string.
data class Ord (val ord: String) {
    override fun toString(): String {
        return ord
    }
}