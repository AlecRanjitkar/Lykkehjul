package com.example.lykkehjul

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lykkehjul.Adapter.ItemAdapter
import com.example.lykkehjul.Data.Datasource
import com.example.lykkehjul.Logik.SpilLogik
import com.example.lykkehjul.Logik.SpilLogik.bogstavToGæt
import com.example.lykkehjul.Logik.SpilLogik.erBogstavIHemmeligtOrd
import com.example.lykkehjul.Logik.SpilLogik.multiplyBogstaver
import com.example.lykkehjul.Model.Ord
import java.lang.StringBuilder

class Spilgame : AppCompatActivity() {
    private lateinit var bogstavLayout: ConstraintLayout
    private lateinit var brugtBogstav: TextView
    private lateinit var Knap: Button
    private lateinit var Besked: TextView
    private lateinit var Knap1: Button
    private lateinit var Liv: TextView
    private lateinit var Point: TextView
    private lateinit var Recycler: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>? = null

    var buttons = mutableListOf<TextView>()
    var hemmeligtOrd = ""
    var gætBogstav = ""
    var tilfældigtSpin = ""
    var point = 0
    var liv = 5
    var hemmeligtOrdIUnderscore = mutableListOf<Ord>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spilgame)

        Recycler = findViewById(R.id.Recycler)
        Knap = findViewById(R.id.Knap)
        bogstavLayout = findViewById(R.id.bogstavLayout)
        brugtBogstav = findViewById(R.id.brugtBogstav)
        Besked = findViewById(R.id.Besked)
        Knap1 = findViewById(R.id.Knap1)
        Liv = findViewById(R.id.Liv)
        Point = findViewById(R.id.Point)

        layoutManager = LinearLayoutManager(this)
        Recycler.layoutManager = layoutManager
        Recycler.adapter = adapter

        //Initialiser bogstaver
        var ord = 'a'
        while (ord <= 'z') {

            val resId = resources.getIdentifier(ord.toString(), "id", packageName)
            val view: TextView = findViewById(resId)
            buttons.add(view)
            ord++
        }
        // Random generator til det hemmeligtord
        val myDataset = Datasource().loadOrd()
        var randomNumber = myDataset.random()
        print(randomNumber)
        hemmeligtOrd = myDataset.random().toString()

        // Random generator til antal point man får
        val myDataset1 = Datasource().loadpoint()
        randomNumber = myDataset1.random()
        print(randomNumber)
        Knap.setOnClickListener {

            val hjulSpin = Datasource().loadpoint()
            tilfældigtSpin = hjulSpin.random().toString()
            Besked.setText(tilfældigtSpin)

        }

        val charArray = hemmeligtOrd.toCharArray()

        val data: MutableList<Ord> = ArrayList()
        for (i in charArray) {
            if (i.equals(' ')) {
                data.add(Ord(" "))
            } else {
                data.add(Ord("."))

            }

        }
        hemmeligtOrdIUnderscore = data
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = ItemAdapter(data)

        Recycler.layoutManager = layoutManager
        Recycler.setHasFixedSize(true)
        Recycler.adapter = adapter


        drejHjul()
        getBogstavFraBruger()
    }

    var erHjuletDrejet = false

    fun drejHjul() {
        Knap.setOnClickListener {
            if (!erHjuletDrejet) {
                val hjulSpin = Datasource().loadpoint()
                tilfældigtSpin = hjulSpin.random().toString()
                Besked.setText(tilfældigtSpin)

                drejHjulIndeholderSpecielleOrd()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Husk at trykke på et bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun drejHjulIndeholderSpecielleOrd() {
        if (tilfældigtSpin.contains("Ekstra liv")) {
            liv += 1
            Liv.setText(liv.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået et ekstra liv",
                Toast.LENGTH_SHORT
            )
                .show()
        } else if (tilfældigtSpin.contains("Tabt liv")) {
            liv -= 1
            Liv.setText(liv.toString())
            Toast.makeText(applicationContext, "Du har mistet et liv", Toast.LENGTH_SHORT)
                .show()
        } else if (tilfældigtSpin.contains("Konkurs")) {
            liv = 0
            Liv.setText(liv.toString())
            Toast.makeText(
                applicationContext,
                "Du er gået konkurs og har hermed tabt spillet",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            erHjuletDrejet = true
        }
    }

    fun fåPoint() {
        if (tilfældigtSpin.equals("10")) {
            point += 10
            Point.setText(point.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået 10 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.equals("100")) {
            point += 100
            Point.setText(point.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået 100 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.equals("500")) {
            point += 500
            Point.setText(point.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået 500 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.equals("1000")) {
            point += 1000
            Point.setText(point.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået 1000 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.equals("1500")) {
            point += 1500
            Point.setText(point.toString())
            Toast.makeText(
                applicationContext,
                "Du har fået 1500 point ",
                Toast.LENGTH_SHORT
            ).show()


        }
    }

    fun getBogstavFraBruger() {
        for (button in buttons) {
            button.setOnClickListener {
                if (erHjuletDrejet) {
                    val tastBogstav = button.text.toString().lowercase()
                    if (erBogstavIHemmeligtOrd(hemmeligtOrd, tastBogstav)) {
                        var setUnderscore = ""
                        for (words in hemmeligtOrdIUnderscore) {
                            setUnderscore += words
                        }
                        val charArray = bogstavToGæt(setUnderscore, hemmeligtOrd, tastBogstav)

                        val data: MutableList<Ord> = ArrayList()
                        for (i in charArray) {
                            data.add(Ord("$i"))

                        }
                        hemmeligtOrdIUnderscore = data
                        layoutManager =
                            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                        adapter = ItemAdapter(data)

                        Recycler.layoutManager = layoutManager
                        Recycler.setHasFixedSize(true)
                        Recycler.adapter = adapter
                        fåPoint()
                        Toast.makeText(
                            applicationContext,
                            "Du har trykket på bogstavet ${button.text.toString().lowercase()}",
                            Toast.LENGTH_SHORT
                        ).show()


                    } else {
                        liv -= 1
                        Liv.setText(liv.toString())
                        Toast.makeText(
                            applicationContext,
                            "Det hemmelig ord har dsv ikke dette bogstav",
                            Toast.LENGTH_SHORT
                        ).show()
                        erHjuletDrejet = false
                    }
                    button.setVisibility(View.GONE)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Husk at rotere hjulet",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                erHjuletDrejet = false

            }
        }


    }


}