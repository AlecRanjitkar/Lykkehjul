package com.example.lykkehjul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lykkehjul.Adapter.ItemAdapter
import com.example.lykkehjul.Data.Datasource
import java.lang.StringBuilder

class Spilgame : AppCompatActivity() {

    lateinit var besked: TextView

    var hemmeligtOrd = ""
    var gætOrd = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spilgame)

        besked = findViewById(R.id.wordTextView)

        val myDataset = Datasource().loadOrd()

        hemmeligtOrd = myDataset.random().toString()

        val sb = StringBuilder()
        hemmeligtOrd.forEach {
            sb.append("_")
        }
        gætOrd = sb.toString()

        besked.setText(gætOrd)



        val randomAnimal = myDataset.random()
        print(randomAnimal)

        val myDataset1 = Datasource().loadpoint()
        val randomNumber = myDataset1.random()
        print(randomNumber)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
        recyclerView.setVisibility(View.INVISIBLE)

        val knap: Button = findViewById(R.id.Knap)
        val besked: TextView = findViewById(R.id.Besked)
        val WordView: TextView = findViewById(R.id.wordTextView)


        knap.setOnClickListener {
            besked.setText(randomNumber.toString())


        }
    }
}