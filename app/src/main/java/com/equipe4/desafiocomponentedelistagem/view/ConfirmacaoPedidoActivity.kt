package com.equipe4.desafiocomponentedelistagem.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.adapter.ItemProdutoOpcionaisAdapter
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityConfirmacaoPedidoBinding
import com.equipe4.desafiocomponentedelistagem.model.ItemProdutoOpcionais

class ConfirmacaoPedidoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityConfirmacaoPedidoBinding.inflate(layoutInflater)
    }

    private lateinit var itemAdapter: ItemProdutoOpcionaisAdapter

    private val listaProdutosComOpcionais = listOf<ItemProdutoOpcionais>(
        ItemProdutoOpcionais(1, "Carne", "Prato mais pedido da casa", R.drawable.carne, 59.90),
        ItemProdutoOpcionais(2, "Choco Banoffee", "Delicioso e cremoso", R.drawable.choco_banoffee_outback, 15.10),
        ItemProdutoOpcionais(3, "Brownie", "Chocolate", R.drawable.brownie_outback, 6.90),
        ItemProdutoOpcionais(4, "Chá Preto", "Tradicional", R.drawable.cha_preto_tradicional_outback, 9.00),
        ItemProdutoOpcionais(5, "Batata Fritas", "", R.drawable.fritas_outback, 9.10),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBotaoVoltar()
        setupRecyclerView()
        setupConfirmarPedido()

    }

    private fun setupConfirmarPedido() {
        binding.btnConfirmarPedido.setOnClickListener {
            Toast.makeText(this, "Clicado, Botão de Confirmar Pedido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBotaoVoltar() {
        binding.btnVoltar.setOnClickListener {
            Toast.makeText(this, "Clicado, Botão de Voltar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        itemAdapter = ItemProdutoOpcionaisAdapter()
        binding.rvItens.layoutManager = LinearLayoutManager(this)
        binding.rvItens.adapter = itemAdapter
        itemAdapter.submitList(listaProdutosComOpcionais)
    }
}