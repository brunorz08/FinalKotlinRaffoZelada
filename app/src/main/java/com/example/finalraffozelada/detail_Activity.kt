package com.example.finalraffozelada

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide



class detail_Activity : AppCompatActivity() {


private lateinit var textViewIngredientes: TextView
private lateinit var fotoReceta: ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewIngredientes = findViewById(R.id.textViewingredientes)
        fotoReceta = findViewById(R.id.imageViewreceta)

        val bundle = intent.extras
        val url = bundle?.getString("url",) ?: ""
        val Ingredientes = bundle?.getString("ingredientes","")

        textViewIngredientes.text = Ingredientes

        Glide.with(applicationContext)
            .load(url)
            .into(fotoReceta)


    }
}