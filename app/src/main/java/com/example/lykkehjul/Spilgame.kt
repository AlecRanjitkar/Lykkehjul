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
import com.example.lykkehjul.Logik.SpilLogik
import java.lang.StringBuilder

class Spilgame : AppCompatActivity() {

    private val spilManager = SpilLogik
    private lateinit var bogstavLayout: ConstraintLayout
    private lateinit var wordTextView: TextView
    private lateinit var brugtBogstav: TextView
    private lateinit var Knap: Button
    private lateinit var Besked: TextView
    private lateinit var Knap1: Button
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


        /* bogstavLayout.children.forEach { bogstavView ->
            if (bogstavView is TextView) {
                bogstavView.setOnClickListener{
                    val spilTilstand = SpilManager.gætBogstav((bogstavView).text[0])
                }
            }
        }
        */

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
            Toast.makeText(applicationContext, "Knap a", Toast.LENGTH_SHORT).show()
            a.setVisibility(View.GONE)
        }
        b = findViewById(R.id.b)
        b.setOnClickListener {
            Toast.makeText(applicationContext, "Knap b", Toast.LENGTH_SHORT).show()
            b.setVisibility(View.GONE)
        }
        c = findViewById(R.id.c)
        c.setOnClickListener {
            Toast.makeText(applicationContext, "Knap c", Toast.LENGTH_SHORT).show()
            c.setVisibility(View.GONE)
        }
        d = findViewById(R.id.d)
        d.setOnClickListener {
            Toast.makeText(applicationContext, "Knap d", Toast.LENGTH_SHORT).show()
            d.setVisibility(View.GONE)
        }
        e = findViewById(R.id.e)
        e.setOnClickListener {
            Toast.makeText(applicationContext, "Knap e", Toast.LENGTH_SHORT).show()
            e.setVisibility(View.GONE)
        }
        f = findViewById(R.id.f)
        f.setOnClickListener {
            Toast.makeText(applicationContext, "Knap f", Toast.LENGTH_SHORT).show()
            f.setVisibility(View.GONE)
        }
        g = findViewById(R.id.g)
        g.setOnClickListener {
            Toast.makeText(applicationContext, "Knap g", Toast.LENGTH_SHORT).show()
            g.setVisibility(View.GONE)
        }
        h = findViewById(R.id.h)
        h.setOnClickListener {
            Toast.makeText(applicationContext, "Knap h", Toast.LENGTH_SHORT).show()
            h.setVisibility(View.GONE)
        }
        i = findViewById(R.id.i)
        i.setOnClickListener {
            Toast.makeText(applicationContext, "Knap i", Toast.LENGTH_SHORT).show()
            i.setVisibility(View.GONE)
        }
        j = findViewById(R.id.j)
        j.setOnClickListener {
            Toast.makeText(applicationContext, "Knap j", Toast.LENGTH_SHORT).show()
            j.setVisibility(View.GONE)
        }
        k = findViewById(R.id.k)
        k.setOnClickListener {
            Toast.makeText(applicationContext, "Knap k", Toast.LENGTH_SHORT).show()
            k.setVisibility(View.GONE)
        }
        l = findViewById(R.id.l)
        l.setOnClickListener {
            Toast.makeText(applicationContext, "Knap l", Toast.LENGTH_SHORT).show()
            l.setVisibility(View.GONE)
        }
        m = findViewById(R.id.m)
        m.setOnClickListener {
            Toast.makeText(applicationContext, "Knap m", Toast.LENGTH_SHORT).show()
            m.setVisibility(View.GONE)
        }
        n = findViewById(R.id.n)
        n.setOnClickListener {
            Toast.makeText(applicationContext, "Knap n", Toast.LENGTH_SHORT).show()
            n.setVisibility(View.GONE)
        }
        o = findViewById(R.id.o)
        o.setOnClickListener {
            Toast.makeText(applicationContext, "Knap o", Toast.LENGTH_SHORT).show()
            o.setVisibility(View.GONE)
        }
        p = findViewById(R.id.p)
        p.setOnClickListener {
            Toast.makeText(applicationContext, "Knap p", Toast.LENGTH_SHORT).show()
            p.setVisibility(View.GONE)
        }
        q = findViewById(R.id.q)
        q.setOnClickListener {
            Toast.makeText(applicationContext, "Knap q", Toast.LENGTH_SHORT).show()
            q.setVisibility(View.GONE)
        }
        r = findViewById(R.id.r)
        r.setOnClickListener {
            Toast.makeText(applicationContext, "Knap r", Toast.LENGTH_SHORT).show()
            r.setVisibility(View.GONE)
        }
        s = findViewById(R.id.s)
        s.setOnClickListener {
            Toast.makeText(applicationContext, "Knap s", Toast.LENGTH_SHORT).show()
            s.setVisibility(View.GONE)
        }
        t = findViewById(R.id.t)
        t.setOnClickListener {
            Toast.makeText(applicationContext, "Knap t", Toast.LENGTH_SHORT).show()
            t.setVisibility(View.GONE)
        }
        u = findViewById(R.id.u)
        u.setOnClickListener {
            Toast.makeText(applicationContext, "Knap u", Toast.LENGTH_SHORT).show()
            u.setVisibility(View.GONE)
        }
        v = findViewById(R.id.v)
        v.setOnClickListener {
            Toast.makeText(applicationContext, "Knap v", Toast.LENGTH_SHORT).show()
            v.setVisibility(View.GONE)
        }
        w = findViewById(R.id.w)
        w.setOnClickListener {
            Toast.makeText(applicationContext, "Knap w", Toast.LENGTH_SHORT).show()
            w.setVisibility(View.GONE)
        }
        x = findViewById(R.id.x)
        x.setOnClickListener {
            Toast.makeText(applicationContext, "Knap x", Toast.LENGTH_SHORT).show()
            x.setVisibility(View.GONE)
        }
        y = findViewById(R.id.y)
        y.setOnClickListener {
            Toast.makeText(applicationContext, "Knap y", Toast.LENGTH_SHORT).show()
            y.setVisibility(View.GONE)
        }
        z = findViewById(R.id.z)
        z.setOnClickListener {
            Toast.makeText(applicationContext, "Knap z", Toast.LENGTH_SHORT).show()
            z.setVisibility(View.GONE)
        }



    }
}


