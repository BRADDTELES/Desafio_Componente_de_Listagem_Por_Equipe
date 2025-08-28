package com.equipe4.desafiocomponentedelistagem.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
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
        ItemProdutoOpcionais(1, "Kookaburra Aussie Tizer", "Crocantes por fora com recheio suculento de frango desfiado com tempero especial do Chef de Alto Nível", R.drawable.kookaburra_aussie_tizer, 79.90),
        ItemProdutoOpcionais(2, "Bloomin’ Onion", "Nossa famosa cebola gigante e dourada", R.drawable.bloomin_onion_outback, 49.90),
        ItemProdutoOpcionais(3, "Brownies from Down Under Ice Cream", "Uma camada com calda de doce de leite Havanna e outra com calda de chocolate, servidas com uma bola de sorvete", R.drawable.choco_banoffee_outback, 29.90),
        ItemProdutoOpcionais(4, "Batata Fritas", "Batatas fritas preparadas ao melhor aussie style", R.drawable.fritas_outback, 30.90),
        ItemProdutoOpcionais(5, "Thunder Brownies", "O delicioso brownie com nozes do nosso famoso Thunder", R.drawable.brownie_outback, 14.90),
        ItemProdutoOpcionais(6, "Chá Preto", "Tradicional", R.drawable.cha_preto_tradicional_outback, 13.90),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBotaoVoltar()
        calcularEAtualizarTotais()
        setupConfirmarPedido()
        setupShimmerFacebook()

    }

    private fun calcularEAtualizarTotais() {
        val subtotal = listaProdutosComOpcionais.sumOf { it.preco }
        val taxaEntrega = 9.90
        val total = subtotal + taxaEntrega

        binding.tvSubTotal.text = "${"%.2f".format(subtotal)}"
        binding.tvTaxaEntrega.text = "R$ ${"%.2f".format(taxaEntrega)}"
        binding.tvTotal.text = "R$ ${"%.2f".format(total)}"
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

    private fun setupShimmerFacebook() {
        binding.shimmerViewContainer.startShimmer()

        // Simula um tempo de carregamento de 2 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            binding.shimmerViewContainer.stopShimmer()
            binding.shimmerViewContainerTextPrice.stopShimmer()
            binding.shimmerViewContainer.visibility = View.GONE
            binding.shimmerViewContainerTextPrice.visibility = View.GONE
            binding.rvItens.visibility = View.VISIBLE
            binding.tvSubTotal.visibility = View.VISIBLE
            binding.tvTaxaEntrega.visibility = View.VISIBLE
            binding.tvTotal.visibility = View.VISIBLE
            setupRecyclerView()
        }, 3000)
    }
}