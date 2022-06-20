package com.andres.sistema_urgencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class mostrar_ambulancias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ambulancias)
        //Botones

        val boton_volver=findViewById<ImageView>(R.id.view_volver_mostrar)

        //Funciones de botones

        boton_volver.setOnClickListener{
            //Este código es  para ir de una ventana a otra
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}