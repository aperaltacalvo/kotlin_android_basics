package com.example.holaandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.holaandroid.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding:ActivityResultBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        val computo = extras.getString("data")
        Toast.makeText(this, computo, Toast.LENGTH_LONG).show()
        //binding.activityResultTvResultado.text=computo


    }

    override fun onStart() {
        super.onStart()
        binding.activityResultBtWeb.setOnClickListener{
            //llamada implicita (intent implicito)
            Log.i("app","activity url started")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.elpais.es"))

            startActivity(intent)
        }
    }
    fun returnData(view: View){
        finish()
    }

    override fun finish(){
        val data = Intent()
        data.putExtra("returnData", "Dato de retorno")
        setResult(RESULT_OK, data)
        super.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("app", "Segunda Actividad Destruida")
    }
}