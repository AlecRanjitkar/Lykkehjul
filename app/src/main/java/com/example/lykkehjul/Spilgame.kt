package com.example.lykkehjul


import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lykkehjul.Adapter.ItemAdapter
import com.example.lykkehjul.Data.Datasource
import com.example.lykkehjul.Logik.SpilLogik.bogstavToGæt
import com.example.lykkehjul.Logik.SpilLogik.erBogstavIHemmeligtOrd
import java.lang.StringBuilder

class Spilgame : AppCompatActivity() {

    private lateinit var bogstavLayout: ConstraintLayout
    private lateinit var wordTextView: TextView
    private lateinit var brugtBogstav: TextView
    private lateinit var Knap: Button
    private lateinit var Besked: TextView
    private lateinit var Knap1: Button
    private lateinit var Liv: TextView
    private lateinit var Point: TextView


    var buttons = mutableListOf<TextView>()
    var hemmeligtOrd = ""
    var gætBogstav = ""
    var tilfældigtSpin = ""
    var point = ""
    var liv = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spilgame)

        Knap = findViewById(R.id.Knap)
        bogstavLayout = findViewById(R.id.bogstavLayout)
        wordTextView = findViewById(R.id.wordTextView)
        brugtBogstav = findViewById(R.id.brugtBogstav)
        Besked = findViewById(R.id.Besked)
        Knap1 = findViewById(R.id.Knap1)
        Liv = findViewById(R.id.Liv)
        Point = findViewById(R.id.Point)

        var letter = 'a'
        while (letter <= 'z') {

            val resId = resources.getIdentifier(letter.toString(), "id", packageName)
            val view: TextView = findViewById(resId)
            buttons.add(view)
            letter++
        }


        val myDataset = Datasource().loadOrd()
        var randomNumber = myDataset.random()
        print(randomNumber)

        hemmeligtOrd = myDataset.random().toString()

        val sb = StringBuilder()
        hemmeligtOrd.forEach {
            sb.append("_")
        }
        gætBogstav = sb.toString()

        wordTextView.setText(gætBogstav)
        wordTextView.setVisibility(View.VISIBLE)


        val myDataset1 = Datasource().loadpoint()
        randomNumber = myDataset1.random()
        print(randomNumber)

        Knap.setOnClickListener {

            val hjulSpin = Datasource().loadpoint()
            tilfældigtSpin = hjulSpin.random().toString()
            Besked.setText(tilfældigtSpin)


        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
        recyclerView.setVisibility(View.INVISIBLE)

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

            } else {
                Toast.makeText(
                    applicationContext,
                    "Husk at trykke på et bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun fåPoint() {
        if (tilfældigtSpin.contains("10")) {
            point += 10
            Point.text = point
            Toast.makeText(
                applicationContext,
                "Du har fået 10 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.contains("100")) {
            point += 100
            Point.text = point
            Toast.makeText(
                applicationContext,
                "Du har fået 100 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.contains("500")) {
            point += 500
            Point.text = point
            Toast.makeText(
                applicationContext,
                "Du har fået 500 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.contains("1000")) {
            point += 1000
            Point.text = point
            Toast.makeText(
                applicationContext,
                "Du har fået 1000 point ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (tilfældigtSpin.contains("1500")) {
            point += 1500
            Point.text = point
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
                    if (erBogstavIHemmeligtOrd(hemmeligtOrd, button.text.toString().lowercase())) {
                        wordTextView.setText(
                            String(
                                bogstavToGæt(
                                    wordTextView.text.toString(),
                                    hemmeligtOrd,
                                    button.text.toString().lowercase()
                                )
                            )
                        )
                        fåPoint()

                        Toast.makeText(
                            applicationContext,
                            "Du har trykket på bogstavet ${button.text.toString().lowercase()}",
                            Toast.LENGTH_SHORT
                        ).show()
                        erHjuletDrejet = false

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