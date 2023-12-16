package com.example.finalraffozelada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecetaAdapter(applicationContext)
        recyclerView.adapter = adapter

        val listaRecetas = getRecetas()
        adapter.submitList(listaRecetas)

        adapter.onItemClickListener = { receta ->
            val intent = Intent(this, detail_Activity::class.java)
            intent.putExtra("ingredientes",receta.ingredientes)
            intent.putExtra("url",receta.url)
            startActivity(intent)
        }



    }
    private fun getRecetas(): MutableList<Receta>{

        return mutableListOf(
            Receta(1,"Empanadas de jamón y queso","Fácil","Argentina","Tapas, Queso, Jamon, Huevo","https://locosxlaparrilla.com/wp-content/uploads/2015/02/Receta-recetas-locos-x-la-parrilla-locosxlaparrilla-receta-empanadas-jamon-queso-empanadas-jamon-queso-receta-empanadas-empanadas-3.jpg"),
            Receta(2,"Ceviche","Dificil","Perú","Especias,Pescado,Verduras,Limon","https://cdn0.recetasgratis.net/es/posts/7/4/1/ceviche_peruano_18147_orig.jpg"),
            Receta(3,"Tequeños","Media","Venezuela","Queso blanco semi duro,Harina,Mantequilla,Huevo,Sal,Azucar,Aceite de maiz,Agua","https://d1kxxrc2vqy8oa.cloudfront.net/wp-content/uploads/2018/12/30092825/RFB-0000-30-tequen%CC%83os.jpg"),
            Receta(4,"Smash Burguer","Fácil","Estados Unidos","Carne picada, Queso Cheddar, Pepinillos, Cebolla Morada, Lechuga, Mayonesa, Pan, Sal, Pimienta Negra,Mantequilla","https://i.blogs.es/f9190d/smash_burger/1366_2000.jpg"),
            Receta(5,"Chivito","Media","Uruguay","Tomate, Sal, Lechuga, Pan, Mayonesa, Carne, Aceite, Huevos, Muzzarella, Jamon","https://imgs.search.brave.com/fO4FodpzlpWac53o7DNCdsSRDxESlvHXCz-fLahDc4k/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2xhcmluLmNvbS9p/bWcvMjAyMS8wOC8w/OS80Z21TazBxTWdf/MzYweDI0MF9fMS5q/cGc"),
            Receta(6,"Milanesa Napolitana con fritas","Fácil","Argentina","Carne, Pan Rallado, Huevo, Papas, Ajo, Perejil, Sal","https://imgs.search.brave.com/w3D4moXyihQWi-me_9dMhGnI7Ntp__bBr6cmLhsZlw0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jdWst/aXQuY29tL3dwLWNv/bnRlbnQvdXBsb2Fk/cy8yMDIyLzA5L21p/bGFuZXNhLW5hcG8t/c3Rvcmllcy01Lndl/YnA"),
            Receta(7,"Buñuelos Colombianos","Media","Colombia","Aceite, Maicena, Harina de Yuca, Queso Fresco, Queso feta, Huevo, Polvo de hornear, Azucar, Sal, Leche","https://www.mycolombianrecipes.com/wp-content/uploads/2009/12/Receta-de-Bunuelos-Colombianos.jpg"),
            Receta(8,"Tacos","Media","México","Tortillas, Carnes, Ajo, Tomate, Sal, Pimienta, Aceite, Vegetales a gusto","https://www.cocinacaserayfacil.net/wp-content/uploads/2016/05/tacos-mexicanos.jpg"),
            Receta(9,"Acarajé","Facil","Brasil","Chicharos, Cebolla, Agua, Sal, Pimienta, Aceite","https://www.cocina-brasilena.com/base/stock/Recipe/30-image/30-image_web.jpg.webp"),
            Receta(10,"Pique Macho","Media","Bolivia","Huevo Duro, Papas, Tomate, Cerveza, Cucharada de salsa de soja, Pimienta Negra, Aceite de oliva","https://i0.wp.com/elcalderoviajero.com/wp-content/uploads/2017/12/bolivia-potosi-12.jpg?w=750&ssl=1")

        )

    }
}