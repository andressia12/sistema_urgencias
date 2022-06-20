package com.andres.sistema_urgencias

import Mundo.SistemaUrgencias.agr_ambulancia
import Mundo.SistemaUrgencias.codigos_ambulancias
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.lang.Exception
import java.text.SimpleDateFormat

class agregar_ambulancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_ambulancia)

        //Botones

        val boton_volver = findViewById<ImageView>(R.id.view_volver_mostrar)
        val boton_agregar_accidentado = findViewById<AppCompatButton>(R.id.bn_ingresar_accidentado_ambulancia)
        val boton_agregar_ambulancia = findViewById<AppCompatButton>(R.id.bn_agregar_ambu_ambulancia)
        val txt_codigo = findViewById<EditText>(R.id.txt_codigo_ambulancia)
        val txt_ubicacion_ambu_calle = findViewById<EditText>(R.id.txt_calle_ambulancia)
        val txt_ubicacion_ambu_carrera = findViewById<EditText>(R.id.txt_carrera_ambulancia)
        val txt_ambulancia_estado = findViewById<EditText>(R.id.txt_carrera_ambulancia)

        //Funciones de botones

        boton_volver.setOnClickListener{
            //Este código es  para ir de una ventana a otra
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        boton_agregar_accidentado.setOnClickListener {
            val intent= Intent(this,agregar_accidentado::class.java)
            startActivity(intent)
        }

        boton_agregar_ambulancia.setOnClickListener {
            try{
                val codigo=txt_codigo.text.toString().toInt()
                val calle_ambulancia=txt_ubicacion_ambu_calle.text.toString().toInt()
                val carrera_ambulancia=txt_ubicacion_ambu_carrera.text.toString().toInt()
                val ambulancia_estado = false

                if(codigo>99 && calle_ambulancia >= 1 && carrera_ambulancia >= 1){
                    agr_ambulancia(codigo,calle_ambulancia,carrera_ambulancia,ambulancia_estado)
                    Toast.makeText(this,"Ambulancia agregada", Toast.LENGTH_LONG).show()
                    println(codigos_ambulancias())
                }
                else{
                    Toast.makeText(this,"Verificar los campos", Toast.LENGTH_LONG).show()
                }

            }
            catch (e: Exception){
                Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
            }
        }


    }
}