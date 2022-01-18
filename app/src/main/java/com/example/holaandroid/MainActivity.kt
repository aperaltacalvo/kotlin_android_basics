package com.example.holaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.util.Log.INFO
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.holaandroid.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {

    private lateinit var etiquetaSaludo: TextView
    //private lateinit var botonSaludo: Button
    //private lateinit var botonActividad: Button
    private lateinit var binding: ActivityMainBinding
    private val request_code = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etiquetaSaludo = findViewById<TextView>(R.id.activity_main_tv_resultado)
       //botonSaludo = findViewById<Button>(R.id.activity_main_button)
       //botonActividad = findViewById<Button>(R.id.activity_main_button_resultado)


        Log.i("app", "Actividad creada")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("app", "Actividad destruida")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == request_code) && (resultCode == RESULT_OK)) {
            data?.let {
                if (it.hasExtra("returnData")) {
                    val resultado = it.extras?.getString("returnData")
                    binding.activityMainTvResultado.text = resultado
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("app", "Actividad iniciada")
        etiquetaSaludo.text = "Actividad Start"

      //  botonSaludo.setOnClickListener {
     //       Log.i("app", "boton pulsado")
     //       Toast.makeText(this, "Boton pulsado", Toast.LENGTH_LONG).show()
     //   }
      //  botonActividad.setOnClickListener {
      //      Log.i("app", "change activity")
      //      Toast.makeText(this, "Cambio de actividad pulsado", Toast.LENGTH_LONG).show()
            //intent explicit
       //     val intent = Intent(this, ResultActivity::class.java)
       //     intent.putExtra("data", "34.9kg")
            //startActivity(intent)
       //     startActivityForResult(intent, request_code)
       //     binding.activityMainButton.text = "saludo"

       // }
        binding.activityMainButton.setOnClickListener {
            Toast.makeText(this, "Boton pulsado con biding", Toast.LENGTH_LONG).show()
        }

        binding.activityMainButtonResultado.setOnClickListener {
            Log.i("app", "change activity with binding")
            Toast.makeText(this, "Cambio de actividad pulsado con binding", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("data", "34.9kg")
            startActivityForResult(intent,request_code)
        }


    }


    }


