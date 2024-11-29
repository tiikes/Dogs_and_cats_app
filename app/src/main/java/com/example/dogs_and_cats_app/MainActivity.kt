package com.example.dogs_and_cats_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var koiranappi: Button
    lateinit var kissanappi: Button

    companion object {
        val valittu_elain = "Valittu eläin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        koiranappi = findViewById(R.id.koiranappi)
        kissanappi = findViewById(R.id.kissanappi)

        koiranappi.setOnClickListener{
            val intent = Intent(this, ToinenActivity:: class.java).apply {
                putExtra(valittu_elain, "Koira")
            }
            startActivity(intent)
        }
        kissanappi.setOnClickListener{
            val intent = Intent(this, ToinenActivity:: class.java).apply {
                putExtra(valittu_elain, "Kissa")
            }
            startActivity(intent)
        }
    }
}