package com.example.examen_practico

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.examen_practico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private var genero = "Serie"
    private var subj = mutableListOf<String>()
    private var provincia = arrayOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.rdHom.setOnClickListener { genero = "Hombre" }
        b.rdMuj.setOnClickListener { genero = "Mujer" }
        b.rdNs.setOnClickListener { genero = "No Indicado" }

        b.btnSave.setOnClickListener { getAndSend()}
        getSpinner(b.spnProv,this,provincia,R.array.provincia)
    }
    fun getAndSend(){
        val intentResult = Intent(this, FichaActivity::class.java)
        //intentResult.putExtra("COVER", b.ivCover.src)
        intentResult.putExtra("NOMBRE", b.edName.text.toString())
        intentResult.putExtra("EDAD",b.edAge.text.toString())
        intentResult.putExtra("TEL",b.edTel.text.toString())
        intentResult.putExtra("MAIL",b.edMAil.text.toString())
        intentResult.putExtra("PROV", provincia[0])
        intentResult.putExtra("GENERO", genero)
        intentResult.putExtra("SUBJECT", subj.toString())
        startActivity(intentResult)
    }

    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val ckName = view.text.toString()
            if (view.isChecked) {
                if (!subj.contains(ckName)) { subj.add(ckName) }
            } else {
                if (subj.contains(ckName)) { subj.remove(ckName) }
            }
            msj(this, ckName, true)

        }
    }

}