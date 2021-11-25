package com.example.lykkehjul.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lykkehjul.Data.Datasource
import com.example.lykkehjul.Logik.SpilLogik.bogstavToGæt
import com.example.lykkehjul.Logik.SpilLogik.erBogstavIHemmeligtOrd
import com.example.lykkehjul.Logik.SpilLogik.multiplyBogstaver
import com.example.lykkehjul.Model.Ord
import androidx.navigation.Navigation
import com.example.lykkehjul.Adapter.ItemAdapter
import com.example.lykkehjul.R


class mainFragment : Fragment() {

    lateinit var Recycler: RecyclerView
    lateinit var Liv: TextView
    lateinit var Point: TextView
    lateinit var Besked: TextView
    lateinit var Knap: Button
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>? = null

    var buttons = mutableListOf<TextView>()
    var hemmeligtOrd = ""
    var tilfældigtSpin = ""
    var point = 0
    var liv = 5
    var hemmeligtOrdIUnderscore = mutableListOf<Ord>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Recycler = view.findViewById(R.id.Recycler)
        Liv = view.findViewById(R.id.Liv)
        Point = view.findViewById(R.id.Point)
        Besked = view.findViewById(R.id.Besked)
        Knap = view.findViewById(R.id.Knap)

        //Random generator til ord fra Datasource klassen
        //Vælger et random ord fra datasouce klassens liste af ord
        val myDataset = Datasource().loadOrd()
        hemmeligtOrd = myDataset.random().toString()

        layoutManager = LinearLayoutManager(activity)
        Recycler.layoutManager = layoutManager
        Recycler.adapter = adapter

        val data: MutableList<Ord> = hemmeligtOrdiUndscoreOgMellemrumIOrdet()
        hemmeligtOrdIUnderscore = data
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        adapter = ItemAdapter(data)
        Recycler.layoutManager = layoutManager
        Recycler.setHasFixedSize(true)
        Recycler.adapter = adapter
        initaliserBogstaver()
        getBogstavFraBruger()
        drejHjul()
    }

    private fun initaliserBogstaver() {
        //Bogstaverne bliver initalisereret
        var ord = 'a'
        while (ord <= 'z') {

            val resId = resources.getIdentifier(ord.toString(), "id", getActivity()?.packageName)
            val view: TextView = requireView().findViewById(resId)
            buttons.add(view)
            ord++
        }
    }

    private fun hemmeligtOrdiUndscoreOgMellemrumIOrdet(): MutableList<Ord> {
        val charArray = hemmeligtOrd.toCharArray()
        val data: MutableList<Ord> = ArrayList()
        for (i in charArray) {
            // Hvis der er mellemrum i det hemmelige ord laves der et mellemrum mellem ordet ellers er et bogstav erstattet med et .
            if (i.equals(' ')) {
                data.add(Ord(" "))
            } else {
                data.add(Ord("."))
            }
        }
        return data
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
                    activity,
                    "Husk at trykke på et bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            spilTabt()
            spilVundet()
        }
    }

    private fun drejHjulIndeholderSpecielleOrd() {
        //Liv (textview) bliver ændret hvis random generator for ord lander på en af disse statments
        if (tilfældigtSpin.contains("Ekstra liv")) {
            liv += 1
            Liv.setText(liv.toString())
            Toast.makeText(activity, "Du har fået et ekstra liv", Toast.LENGTH_SHORT)
                .show()

        } else if (tilfældigtSpin.contains("Tabt liv")) {
            liv -= 1
            Liv.setText(liv.toString())
            Toast.makeText(activity, "Du har mistet et liv", Toast.LENGTH_SHORT).show()

        } else if (tilfældigtSpin.contains("Konkurs")) {
            liv = 0
            Liv.setText(liv.toString())

        } else {
            erHjuletDrejet = true
        }

    }

    fun fåPoint(tastBogstav: String) {
        //Point textview ændres hvis point generatoren lander på en af disse statments
        if (tilfældigtSpin.equals("10")) {
            point += 10 * multiplyBogstaver(hemmeligtOrd, tastBogstav)
            Point.setText(point.toString())

        } else if (tilfældigtSpin.equals("100")) {
            point += 100 * multiplyBogstaver(hemmeligtOrd, tastBogstav)
            Point.setText(point.toString())

        } else if (tilfældigtSpin.equals("500")) {
            point += 500 * multiplyBogstaver(hemmeligtOrd, tastBogstav)
            Point.setText(point.toString())

        } else if (tilfældigtSpin.equals("1000")) {
            point += 1000 * multiplyBogstaver(hemmeligtOrd, tastBogstav)
            Point.setText(point.toString())

        } else if (tilfældigtSpin.equals("1500")) {
            point += 1500 * multiplyBogstaver(hemmeligtOrd, tastBogstav)
            Point.setText(point.toString())
        }
    }

    fun getBogstavFraBruger() {
        for (button in buttons) {
            button.setOnClickListener {
                if (erHjuletDrejet) {
                    val tastBogstav = button.text.toString().lowercase()
                    if (erBogstavIHemmeligtOrd(hemmeligtOrd, tastBogstav)) {
                        fåPoint(tastBogstav)
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
                            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                            adapter = ItemAdapter(data)

                        Recycler.layoutManager = layoutManager
                        Recycler.setHasFixedSize(true)
                        Recycler.adapter = adapter
                        Toast.makeText(
                            activity,
                            "Du har trykket på bogstavet ${button.text.toString().lowercase()}",
                            Toast.LENGTH_SHORT
                        ).show()


                    } else {
                        // mister et liv hvis hemmeligt ord ikke indeholder bogstav
                        liv -= 1
                        Liv.setText(liv.toString())
                        Toast.makeText(
                            activity,
                            "Det hemmelig ord har dsv ikke dette bogstav, du har mistet et liv",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    erHjuletDrejet = false
                    button.setVisibility(View.GONE)
                } else {
                    Toast.makeText(activity, "Husk at rotere hjulet", Toast.LENGTH_SHORT)
                        .show()
                }
                spilVundet()
                spilTabt()
            }
        }
    }

    private fun spilVundet() {
        if (!hemmeligtOrdIUnderscore.contains(Ord("."))) {
            view?.let {
                Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_vandtFragment)
            }
        }
    }

    private fun spilTabt() {
        if (liv == 0) {
            view?.let {
                Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_tabtFragment)
            }
        }
    }
}

