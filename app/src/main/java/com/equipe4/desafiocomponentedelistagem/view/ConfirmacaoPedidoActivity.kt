package com.equipe4.desafiocomponentedelistagem.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityConfirmacaoPedidoBinding

class ConfirmacaoPedidoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityConfirmacaoPedidoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}