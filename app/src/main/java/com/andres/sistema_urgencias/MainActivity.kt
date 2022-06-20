package com.andres.sistema_urgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //botones
        val boton_agregar_ambulancia=findViewById<AppCompatButton>(R.id.bn_ambulancia_main)
        val boton_agregar_hospital=findViewById<AppCompatButton>(R.id.bn_hospital_main)
        val boton_mostrar_hospitales=findViewById<AppCompatButton>(R.id.bn_lista_hospitales_main)
        val boton_mostrar_accidentados=findViewById<AppCompatButton>(R.id.bn_lista_accidentados_main)
        val boton_mostrar_ambulancias=findViewById<AppCompatButton>(R.id.bn_lista_ambulancias_main)

        //Funciones de los botones
        boton_agregar_ambulancia.setOnClickListener {
            val intent= Intent(this,agregar_ambulancia::class.java)
            startActivity(intent)
        }

        boton_agregar_hospital.setOnClickListener {
            val intent= Intent(this,agregar_hospital::class.java)
            startActivity(intent)
        }

        boton_mostrar_hospitales.setOnClickListener {
            val intent= Intent(this,mostrar_hospitales::class.java)
            startActivity(intent)
        }

        boton_mostrar_accidentados.setOnClickListener {
            val intent= Intent(this,mostrar_accidentados::class.java)
            startActivity(intent)
        }

        boton_mostrar_ambulancias.setOnClickListener {
            val intent= Intent(this,mostrar_ambulancias::class.java)
            startActivity(intent)
        }
    }
}