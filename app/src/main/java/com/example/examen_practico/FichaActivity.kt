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
        val datos = intent.extras

        val str = """   DATOS
            Nombre: ${datos?.get("NOMBRE")}
            Edad: ${datos?.get("EDAD")}
            Tel.:${datos?.get("TEL")}
            E-mail:${datos?.get("MAIL")}
            Provincia: ${datos?.get("PROV")}
            Género: ${datos?.get("GENERO")}
            Asignaturas: ${datos?.get("SUBJECT")}
        """.trimIndent()
        b.tvData.text = str
        b.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}