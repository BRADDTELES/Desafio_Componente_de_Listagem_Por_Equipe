package com.equipe4.desafiocomponentedelistagem.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
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

    @SuppressLint("RestrictedApi")
    private fun setupRecyclerView() {
        categoriaAdapter = CategoriaAdapter{ categoria, position ->
            when(position) {
                0 -> { startActivity(Intent(this, InicialRestauranteActivity::class.java)) }
                else -> {
                    val snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG)
                    val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

                    snackbar.anchorView = binding.materialCardView

                    val params = snackbarLayout.layoutParams as FrameLayout.LayoutParams
                    params.gravity = Gravity.BOTTOM
                    snackbarLayout.layoutParams = params

                    snackbar.view.setBackgroundColor(Color.TRANSPARENT)
                    snackbarLayout.setPadding(0, 0, 0, 0)

                    val customSnackbarView = layoutInflater.inflate(R.layout.layout_snackbar_notification_aviso, null)
                    snackbarLayout.addView(customSnackbarView, 0)

                    snackbar.show()
                }
            }
        }
        binding.rvCategorias.adapter = categoriaAdapter
        binding.rvCategorias.layoutManager = LinearLayoutManager(this)
        categoriaAdapter.submitList(listaCategorias)
    }
}