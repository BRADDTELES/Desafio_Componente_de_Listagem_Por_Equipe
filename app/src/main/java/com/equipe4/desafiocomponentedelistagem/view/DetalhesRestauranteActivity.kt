package com.equipe4.desafiocomponentedelistagem.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.adapter.ProdutosAdapter
import com.equipe4.desafiocomponentedelistagem.adapter.ProdutosDestaqueAdapter
import com.equipe4.desafiocomponentedelistagem.model.Produtos
import com.equipe4.desafiocomponentedelistagem.model.ProdutosDestaque

class DetalhesRestauranteActivity : AppCompatActivity() { // Activity principal (metade superior: imagens | metade inferior: lista)

     override fun onCreate(savedInstanceState: Bundle?) { // Método chamado ao criar a Activity
        super.onCreate(savedInstanceState)               // Chama implementação da superclasse
        setContentView(R.layout.activity_detalhes_restaurante)           // Associa o layout XML desta tela

        // Botão voltar
        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }

        // Configuração do RecyclerView horizontal
        // ---------------------------------------
        val recyclerHorizontal = findViewById<RecyclerView>(R.id.recyclerHorizontal)
        recyclerHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerHorizontal.adapter = ProdutosDestaqueAdapter(gerarListaHorizontal())

        // Configuração do RecyclerView vertical
        // -------------------------------------
        val recyclerVertical = findViewById<RecyclerView>(R.id.recyclerVertical)
        recyclerVertical.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerVertical.adapter = ProdutosAdapter(gerarListaVertical()) {produtoClicado ->
            Log.d("DetalhesRestaurante", "Produto clicado: ${produtoClicado.nome}")
            val intent = Intent(this, DetalhesProdutoActivity::class.java)
            // intent.putExtra("NOME_PRODUTO", produtoClicado.nome)
            // intent.putExtra("DESCRICAO_PRODUTO", produtoClicado.descricao)
            // intent.putExtra("PRECO_PRODUTO", produtoClicado.preco)
            // intent.putExtra("IMAGEM_PRODUTO", produtoClicado.imagemResId)
            startActivity(intent)
        }
    }

    // Lista dos produtos em destaque
    // ------------------------------
    private fun gerarListaHorizontal(): List<ProdutosDestaque> {
        return listOf(
            ProdutosDestaque("Chicken on the Barbie", "R$ 74,90", R.drawable.destaque10),
            ProdutosDestaque("Chicken Fingers Jumbo", "R$ 74,90", R.drawable.destaque20),
            ProdutosDestaque("Smoked Cheeseburger", "R$ 49,90", R.drawable.destaque30),
            ProdutosDestaque("The Outbacker", "R$ 62,90", R.drawable.destaque40),
            ProdutosDestaque("Toowoomba Pasta", "R$ 84,90", R.drawable.destaque50)
        )
    }

    // Lista de todos os produtos
    // --------------------------
    private fun gerarListaVertical(): List<Produtos> {
        return listOf(
            Produtos(
                "Chicken on the Barbie",
                "Um suculento peito de frango grelhado em chama aberta, seervido com o molho Barbecue.",
                "R$ 74,90",
                R.drawable.destaque10),
            Produtos(
                "Chicken Fingers Jumbo",
                "4 pedaços crocantes de peito de frango empanado para você mergulhar no delicioso molho Honey Mustard.",
                "R$ 74,90",
                R.drawable.destaque20),
            Produtos(
                "Smoked Cheeseburger",
                "200g de hambúrger da casa no pão tipo brioche, queijo tipo cheddar, queijo tipo ementhal, cubos de cebola ...",
                "R$ 49,90",
                R.drawable.destaque30),
            Produtos(
                "The Outbacker",
                "200g de hambúrguer de carne, queijo, picles, tomate, alface, cebola, maionese um acompanhamento...",
                "R$ 62,90",
                R.drawable.destaque40),
            Produtos(
                "Toowoomba Pasta",
                "Uma combinação perfeita de camarões e champignons, temperada com ervas finas e servida com fettuccine...",
                "R$ 84,90",
                R.drawable.destaque50)

        )
    }
}