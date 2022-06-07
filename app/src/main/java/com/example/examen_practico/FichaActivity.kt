package com.example.examen_practico

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.examen_practico.databinding.ActivityFichaBinding
import com.example.examen_practico.databinding.ActivityMainBinding

class FichaActivity : AppCompatActivity() {
    private lateinit var b: ActivityFichaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFichaBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}