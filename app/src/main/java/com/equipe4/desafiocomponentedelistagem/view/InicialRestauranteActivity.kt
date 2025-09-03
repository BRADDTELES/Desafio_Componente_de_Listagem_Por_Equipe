package com.equipe4.desafiocomponentedelistagem.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.adapter.LojaAdapter
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityInicialRestauranteBinding
import com.equipe4.desafiocomponentedelistagem.model.Loja

class InicialRestauranteActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInicialRestauranteBinding.inflate(layoutInflater)
    }

    private lateinit var lojaAdapter: LojaAdapter

    private val listaLojas = listOf(
        Loja(1, "McDonald's", R.drawable.mcdonalds, "Restaurante", 4.1, "2km", "40 - 50 min", 9.99),
        Loja(2, "Outback Steakhouse", R.drawable.logo_outback, "Restaurante", 4.1, "2km", "40 - 50 min", 9.99),
        Loja(3, "Subway", R.drawable.subway, "Restaurante", 4.1, "2km", "40 - 50 min", 9.99),
        Loja(4, "Burger King", R.drawable.burger_king, "Restaurante", 4.1, "2km", "40 - 50 min", 9.99),
        Loja(5, "Habib's", R.drawable.habibs, "Restaurante", 4.1, "2km", "40 - 50 min", 9.99),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        lojaAdapter = LojaAdapter { loja ->
            val intent = Intent(this, DetalhesRestauranteActivity::class.java)
            startActivity(intent)
        }
        binding.rvLojas.adapter = lojaAdapter
        binding.rvLojas.layoutManager = LinearLayoutManager(this)
        lojaAdapter.submitList(listaLojas)
    }

}