package com.equipe4.desafiocomponentedelistagem.view

import android.annotation.SuppressLint
import android.content.Intent
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

    private lateinit var nomeProdutoPedido: String
    private lateinit var descricaoProdutoPedido: String
    private var valorProdutoPedido:Double=20.0
    private var valorTotalPedido:Double=0.0

    private var qtdProdutosPedidos:Int=1





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

        val bundle=intent.extras // recuperando os dados da activity Detalhes de restaurantes
        if(bundle!=null) {
            nomeProdutoPedido=bundle.getString("nomeProduto","Combo Hamburger+Batata+MilkShake")
            descricaoProdutoPedido = bundle.getString("descricaoProduto","Combo completo para animar seu final de semana")
            valorProdutoPedido = bundle.getDouble("valorProduto",20.0)
            //falta recuperar imagem

            binding.textViewNomeProdutoPedido.text=nomeProdutoPedido
            binding.textViewDescricaoProdutoPedido.text=descricaoProdutoPedido
            binding.textViewValorProdutoPedido.text="R$ ${valorProdutoPedido}"
            binding.textViewValorTotalDoPedido.text="R$ ${valorProdutoPedido}"

        }
        valorTotalPedido=valorProdutoPedido


            binding.floatingActionButton.setOnClickListener { finish() }

        val opcionalDePedidoAdapter=OpcionalDePedidoAdapter(listaOpcionais,{
            valorTotalPedido+=it
            binding.textViewValorTotalDoPedido.text="R$ $valorTotalPedido"
        })
        binding.recyclerViewOpcionais.adapter= opcionalDePedidoAdapter
        binding.recyclerViewOpcionais.layoutManager= LinearLayoutManager(this)
       /* binding.recyclerViewOpcionais.setOnClickListener {
            valorTotalPedido+=opcionalDePedidoAdapter.valorTotalOpcionais
            binding.textViewValorTotalDoPedido.text="R$ $valorTotalPedido"
        }*/



        binding.imageViewMenosProdutos.setOnClickListener {
            qtdProdutosPedidos= binding.textViewQtdProdutosPedidos.text.toString().toInt()
            if (qtdProdutosPedidos>=1){
                qtdProdutosPedidos=binding.textViewQtdProdutosPedidos.text.toString().toInt()-1
                binding.textViewQtdProdutosPedidos.text="$qtdProdutosPedidos"
                valorTotalPedido-=valorProdutoPedido
                binding.textViewValorTotalDoPedido.text="R$ ${valorTotalPedido}"
            }
        }

        binding.imageViewAdicionarProduto.setOnClickListener {
            qtdProdutosPedidos=binding.textViewQtdProdutosPedidos.text.toString().toInt()+1
            binding.textViewQtdProdutosPedidos.text="$qtdProdutosPedidos"
            valorTotalPedido+=valorProdutoPedido
            binding.textViewValorTotalDoPedido.text="R$ ${valorTotalPedido}"
        }

        binding.btnConfirmarPedido.setOnClickListener {
            val intent=Intent(this, PerfilActivity::class.java)
            /*val intent=Intent(this,ConfirmacaoPedidoActivity::class.java)
            intent.putExtra("nomeProdutoPedido",)
            intent.putExtra("qtdProdutosPedidos",qtdProdutosPedidos)
            intent.putExtra("valorProdutoPedido",qtdProdutosPedidos)
                ..*/
            startActivity(intent)
        }

    }
}