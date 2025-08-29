package com.equipe4.desafiocomponentedelistagem.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.adapter.CategoriaAdapter
import com.equipe4.desafiocomponentedelistagem.databinding.ActivityPerfilBinding
import com.equipe4.desafiocomponentedelistagem.model.Categorias
import com.equipe4.desafiocomponentedelistagem.model.Usuario
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

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
        categoriaAdapter = CategoriaAdapter{ categoria, position ->
            when (position) {
                0 -> {
                    val snackbar = Snackbar.make(binding.root, "Navegar para a Tela Inicial Restaurantes",
                        Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.verde_snackbar)) // Mudar a cor de fundo
                    snackbar.setTextColor(ContextCompat.getColor(this, R.color.white)) // Mudar a cor do texto da mensagem
                    snackbar.setAction("OK") {
                        // Este bloco é executado se o usuário clicar no botão "OK" ou pode ficar vazio se for apenas para fechar o snackbar.
                    } // Adicionar um botão de ação (ex: "OK") e definir a cor do texto dele
                    snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.white))
                        .show()
                }
                else -> {
                    val notificationBinding = binding.customNotification

                    //notificationBinding.root.visibility = View.VISIBLE
                    notificationBinding.shimmerViewContainer.startShimmer()

                    animarEntradaNotificacao()

                    Handler(Looper.getMainLooper()).postDelayed({
                        notificationBinding.root.visibility = View.GONE
                        notificationBinding.shimmerViewContainer.stopShimmer()
                    }, 4000)

                }
            }
        }
        binding.rvCategorias.adapter = categoriaAdapter
        binding.rvCategorias.layoutManager = LinearLayoutManager(this)
        categoriaAdapter.submitList(listaCategorias)
    }

    private fun animarEntradaNotificacao() {
        val notificacaoView = binding.customNotification.root

        notificacaoView.alpha = 0f
        notificacaoView.translationX = -50f

        notificacaoView.visibility = View.VISIBLE

        notificacaoView.animate()
            .alpha(1f)
            .translationX(0f)
            .setDuration(1000)
            .start()
    }
}