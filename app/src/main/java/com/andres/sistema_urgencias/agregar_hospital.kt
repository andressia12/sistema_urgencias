package com.andres.sistema_urgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class agregar_hospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_hospital)

        //Botones

        val boton_volver=findViewById<ImageView>(R.id.view_volver_mostrar)

        //Funciones de los botones
        boton_volver.setOnClickListener{
            //Este código es  para ir de una ventana a otra
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}