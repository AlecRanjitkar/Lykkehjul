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
import com.example.lykkehjul.Model.Datasource
import com.example.lykkehjul.Logik.SpilLogik.bogstavToGæt
import com.example.lykkehjul.Logik.SpilLogik.erBogstavIHemmeligtOrd
import com.example.lykkehjul.Logik.SpilLogik.antalGættetBogstavIHemmeligeOrd
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


        val myDataset = Datasource().loadOrd()
        hemmeligtOrd = myDataset.random().toString()

        // Vertical LinearLayoutManager bliver initialiseret som layout manager
        // for RecyclerView og indstiller adapteren til RecyclerView til adapter variablen.
        layoutManager = LinearLayoutManager(activity)
        Recycler.layoutManager = layoutManager
        Recycler.adapter = adapter

        val data: MutableList<Ord> = hemmeligtOrdiUndscoreOgMellemrumIOrdet()
        hemmeligtOrdIUnderscore = data
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        // Initialiseret en ny instance af ItemAdapter klassen
        // Recyclerview er tildelt en ny layoutManager
        adapter = ItemAdapter(data)
        Recycler.layoutManager = layoutManager
        Recycler.setHasFixedSize(true)
        Recycler.adapter = adapter

        initaliserBogstaver()
        getBogstavFraBruger()
        drejHjul()
    }

    private fun initaliserBogstaver() {
        //Initalisere buttons for alle bogstaver i det engelske alphabet, ved at loop igennem alle bogstaver
        // og finde den tilsvarnede button view ved brug af resource ID og derefter tilføjet til en liste a buttons
        var bogstav = 'a'
        while (bogstav <= 'z') {

            val resId = resources.getIdentifier(bogstav.toString(), "id", getActivity()?.packageName)
            val view: TextView = requireView().findViewById(resId)
            buttons.add(view)
            bogstav++
        }
    }

    private fun hemmeligtOrdiUndscoreOgMellemrumIOrdet(): MutableList<Ord> {
        val charArray = hemmeligtOrd.toCharArray()
        val data: MutableList<Ord> = ArrayList()
        for (i in charArray) {
            // Hvis der er mellemrum i det hemmelige ord laves der et mellemrum det samme sted
            // i ordet ellers er et bogstav erstattet med et underscore
            if (i.equals(' ')) {
                data.add(Ord(" "))
            } else {
                data.add(Ord("_"))
            }
        }
        // returnere færdig liste af ord objektet
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
        }
    }

    private fun drejHjulIndeholderSpecielleOrd() {
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
            spilTabt()

        } else {
            erHjuletDrejet = true
        }

    }

    //opdatere og udregner spillerens score udfra det gættede bogstav
    fun fåPoint(tastBogstav: String) {
        // Oprettet variabel pointMultiplier ved at brug when expresson, som checker værdien af tilfældigtSpin
        val pointMultiplier = when (tilfældigtSpin) {
            "10" -> 10
            "100" -> 100
            "500" -> 500
            "1000" -> 1000
            "1500" -> 1500
            else -> 0
        }
        point += pointMultiplier * antalGættetBogstavIHemmeligeOrd(hemmeligtOrd, tastBogstav)
        Point.setText(point.toString())
    }

    fun getBogstavFraBruger() {
        for (button in buttons) {
            button.setOnClickListener {
                if (erHjuletDrejet) {

                    val tastBogstav = button.text.toString().lowercase()

                    if (erBogstavIHemmeligtOrd(hemmeligtOrd, tastBogstav)) {
                        fåPoint(tastBogstav)

                        //sammenkæder all underscores og mellemrum i hemmeligtOrdIUnderscore indtil en single string
                        // som bliver brugt til at vise det hemmelig ord med de korrekte gættede bogstaver
                        var setUnderscore = ""
                        for (letter in hemmeligtOrdIUnderscore) {
                            setUnderscore += letter
                        }

                        val charArray = bogstavToGæt(setUnderscore, hemmeligtOrd, tastBogstav)

                        //Oprettet en ny liste kaldt data af objektet Ord og initalisere det til en tom arrayliste
                        // Iterere igennem charArrayen og tilføjer ethvert element som en ny Ord objekt i data
                        val data: MutableList<Ord> = ArrayList()
                        for (i in charArray) {
                            data.add(Ord("$i"))
                        }
                        hemmeligtOrdIUnderscore = data
                        updateRecyclerView(data)

                        Toast.makeText(
                            activity,
                            "Du har trykket på bogstavet ${button.text.toString().lowercase()}",
                            Toast.LENGTH_SHORT
                        ).show()


                    } else {
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

    // Opdatere RecyclerView med det nye gættede bogstav ved at lave en ny adapter og
    // opdatere også layoutManageren og adapteren af recyclerview
    private fun updateRecyclerView(data: MutableList<Ord>) {
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = ItemAdapter(data)
        Recycler.layoutManager = layoutManager
        Recycler.setHasFixedSize(true)
        Recycler.adapter = adapter
    }


    private fun spilVundet() {
        if (!hemmeligtOrdIUnderscore.contains(Ord("_"))) {
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


/*
fun getBogstavFraBruger() {
        a = findViewById(R.id.a)
        a.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "a")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "a"
                        )
                    )
                )

                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet a",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            a.setVisibility(View.GONE)
        }
 */