package com.example.lykkehjul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var a: TextView
    private lateinit var b: TextView
    private lateinit var c: TextView
    private lateinit var d: TextView
    private lateinit var e: TextView
    private lateinit var f: TextView
    private lateinit var g: TextView
    private lateinit var h: TextView
    private lateinit var i: TextView
    private lateinit var j: TextView
    private lateinit var k: TextView
    private lateinit var l: TextView
    private lateinit var m: TextView
    private lateinit var n: TextView
    private lateinit var o: TextView
    private lateinit var p: TextView
    private lateinit var q: TextView
    private lateinit var r: TextView
    private lateinit var s: TextView
    private lateinit var t: TextView
    private lateinit var u: TextView
    private lateinit var v: TextView
    private lateinit var w: TextView
    private lateinit var x: TextView
    private lateinit var y: TextView
    private lateinit var z: TextView

    var hemmeligtOrd = ""
    var gætBogstav = ""

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
            Besked.setText(randomNumber.toString())

        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
        recyclerView.setVisibility(View.INVISIBLE)

        getBogstavFraBruger()
    }

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

        b = findViewById(R.id.b)
        b.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "b")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "b"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet b",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            b.setVisibility(View.GONE)
        }

        c = findViewById(R.id.c)
        c.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "c")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "o"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet c",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            c.setVisibility(View.GONE)
        }

        d = findViewById(R.id.d)
        d.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "d")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "d"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet d",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            d.setVisibility(View.GONE)
        }

        e = findViewById(R.id.e)
        e.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "e")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "e"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet e",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            e.setVisibility(View.GONE)
        }

        f = findViewById(R.id.f)
        f.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "f")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "f"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet f",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            f.setVisibility(View.GONE)
        }

        g = findViewById(R.id.g)
        g.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "g")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "g"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet g",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            g.setVisibility(View.GONE)
        }

        h = findViewById(R.id.h)
        h.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "h")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "h"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet h",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            h.setVisibility(View.GONE)
        }

        i = findViewById(R.id.i)
        i.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "i")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "i"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet i",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            i.setVisibility(View.GONE)
        }

        j = findViewById(R.id.j)
        j.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "j")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "j"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet j",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            j.setVisibility(View.GONE)
        }

        k = findViewById(R.id.k)
        k.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "k")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "k"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet k",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            k.setVisibility(View.GONE)
        }

        l = findViewById(R.id.l)
        l.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "l")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "l"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet l",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            l.setVisibility(View.GONE)
        }

        m = findViewById(R.id.m)
        m.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "m")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "m"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet m",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            m.setVisibility(View.GONE)
        }

        n = findViewById(R.id.n)
        n.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "n")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "n"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet n",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            n.setVisibility(View.GONE)
        }

        o = findViewById(R.id.o)
        o.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "o")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "o"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet o",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            o.setVisibility(View.GONE)
        }

        p = findViewById(R.id.p)
        p.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "p")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "p"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet p",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            p.setVisibility(View.GONE)
        }

        q = findViewById(R.id.q)
        q.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "q")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "q"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet q",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            q.setVisibility(View.GONE)
        }
        r = findViewById(R.id.r)
        r.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "r")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "r"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet r",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            r.setVisibility(View.GONE)
        }

        s = findViewById(R.id.s)
        s.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "s")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "s"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet s",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            s.setVisibility(View.GONE)
        }

        t = findViewById(R.id.t)
        t.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "t")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "t"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet t",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            t.setVisibility(View.GONE)
        }

        u = findViewById(R.id.u)
        u.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "u")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "u"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet u",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            u.setVisibility(View.GONE)
        }

        v = findViewById(R.id.v)
        v.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "v")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "v"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet v",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            v.setVisibility(View.GONE)
        }

        w = findViewById(R.id.w)
        w.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "w")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "w"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet w",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            w.setVisibility(View.GONE)
        }

        x = findViewById(R.id.x)
        x.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "x")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "x"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet x",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            x.setVisibility(View.GONE)
        }

        y = findViewById(R.id.y)
        y.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "y")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "y"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet y",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            y.setVisibility(View.GONE)
        }

        z = findViewById(R.id.z)
        z.setOnClickListener {
            if (erBogstavIHemmeligtOrd(hemmeligtOrd, "z")) {
                wordTextView.setText(
                    String(
                        bogstavToGæt(
                            wordTextView.text.toString(),
                            hemmeligtOrd,
                            "z"
                        )
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Du har trykket på bogstavet z",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Det hemmelig ord har dsv ikke dette bogstav",
                    Toast.LENGTH_SHORT
                ).show()
            }
            z.setVisibility(View.GONE)
        }
    }
}

