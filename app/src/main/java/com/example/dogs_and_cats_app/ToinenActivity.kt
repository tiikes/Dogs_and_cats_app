package com.example.dogs_and_cats_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ToinenActivity : AppCompatActivity() {
    lateinit var lista: ListView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toinen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView = findViewById<TextView>(R.id.valittueläin)
        val valittu_elain = intent.getStringExtra(MainActivity.valittu_elain)

        textView.text = "Valittu eläin: $valittu_elain"

        lista = findViewById(R.id.uusilista)

        val koirat = arrayListOf(
            Koirat("Walesinspringerspanieli"),
            Koirat("Cockerspanieli"),
            Koirat("Englanninspringerspanieli"),
            Koirat("Fieldspanieli"),
            Koirat("Ranskanspanieli")
        )
        val kissat = arrayListOf(
            Kissat("Siamese"),
            Kissat("Persialainen"),
            Kissat("Ragdoll"),
            Kissat("Maine Coon"),
            Kissat("Sphynx")
        )
        val tietolahde: ArrayList<Any> = when (valittu_elain) {
            "Koira" -> ArrayList<Any>(koirat)
            "Kissa" -> ArrayList<Any>(kissat)
            else -> arrayListOf()
        }
        val adapteri = Adapteri(this, tietolahde)
        lista.adapter = adapteri
    }
}