package com.equipe4.desafiocomponentedelistagem.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityInicialRestauranteBinding

class InicialRestauranteActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInicialRestauranteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupNavegar()
    }

    private fun setupNavegar() {
        binding.btnNavegar.setOnClickListener {
            startActivity(Intent(this, DetalhesRestauranteActivity::class.java))
        }
    }
}