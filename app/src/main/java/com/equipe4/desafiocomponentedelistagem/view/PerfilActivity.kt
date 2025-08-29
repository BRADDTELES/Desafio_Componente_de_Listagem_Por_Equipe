package com.equipe4.desafiocomponentedelistagem.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.adapter.CategoriaAdapter
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityPerfilBinding
import com.equipe4.desafiocomponentedelistagem.model.Categorias
import com.equipe4.desafiocomponentedelistagem.model.Usuario
import androidx.recyclerview.widget.LinearLayoutManager

class PerfilActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPerfilBinding.inflate(layoutInflater)
    }

    private lateinit var categoriaAdapter: CategoriaAdapter

    private val usuario = Usuario(1, "Jamilton Damasceno")

    private val listaCategorias = listOf<Categorias>(
        Categorias(1, "Conversas", "Meu histórico de conversas", R.drawable.ic_conversas, true, 4),
        Categorias(2, "Notificações", "Minha central  de notificações", R.drawable.ic_notificacao, true, 12),
        Categorias(3, "Dados da conta", "Minhas informações da conta", R.drawable.ic_dados_da_conta, false),
        Categorias(4, "Pagamentos", "Meus saldos e cartões", R.drawable.ic_cartoes, false),
        Categorias(5, "Clube iFood", "Meus benefícios exclusivos", R.drawable.ic_diamante, false),
        Categorias(6, "Cupons", "Meus cupons de desconto", R.drawable.ic_cupons, true, 5),
        Categorias(7, "Código de entrega", "Edite seu código de entrega", R.drawable.ic_codigo_entrega, false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        setupPerfil()

    }

    private fun setupPerfil() {
        binding.tvNomeUsuario.text = usuario.nome
    }

    private fun setupRecyclerView() {
        categoriaAdapter = CategoriaAdapter{ categoria ->
            Toast.makeText(this, "Clicado em ${categoria.nome}", Toast.LENGTH_SHORT).show()
        }
        binding.rvCategorias.adapter = categoriaAdapter
        binding.rvCategorias.layoutManager = LinearLayoutManager(this)
        categoriaAdapter.submitList(listaCategorias)
    }
}