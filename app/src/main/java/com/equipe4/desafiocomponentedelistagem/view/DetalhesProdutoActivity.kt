package com.equipe4.desafiocomponentedelistagem.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityDetalhesProdutoBinding
import com.equipe4.desafiocomponentedelistagem.helper.OpcionalDePedidoAdapter
import com.equipe4.desafiocomponentedelistagem.model.Opcional
import com.equipe4.desafiocomponentedelistagem.R

class DetalhesProdutoActivity : AppCompatActivity() {

   // private lateinit var opcionalDePedidoAdapter: OpcionalDePedidoAdapter
    private val binding by lazy { ActivityDetalhesProdutoBinding.inflate(layoutInflater) }

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val listaOpcionais= listOf(
            Opcional("Picles","teste",10.0,R.drawable.picles,0),
            Opcional("Queijo","Incremente seu lanche com esse sabor",5.0,R.drawable.queijo,0)
        )

        binding.recyclerViewOpcionais.adapter= OpcionalDePedidoAdapter(listaOpcionais)
        binding.recyclerViewOpcionais.layoutManager= LinearLayoutManager(this)

    }
}