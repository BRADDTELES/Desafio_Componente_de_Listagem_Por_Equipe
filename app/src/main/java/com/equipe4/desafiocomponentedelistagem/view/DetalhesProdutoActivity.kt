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
import com.equipe4.desafiocomponentedelistagem.adapter.OpcionalDePedidoAdapter
import com.equipe4.desafiocomponentedelistagem.model.Opcional
import com.equipe4.desafiocomponentedelistagem.R
import kotlin.math.roundToInt

class DetalhesProdutoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetalhesProdutoBinding.inflate(layoutInflater) }

/*    private lateinit var nomeProdutoPedido: String
    private lateinit var descricaoProdutoPedido: String*/
    private var valorProdutoPedido:Double=20.0

    private var qtdProdutosPedidos:Int=1

    private var valorTotalPedido:Double=20.0

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

      // este codigo usa para passar pedido da Activity anterior (Detalhes de restaurantes). Para esta tarefa da aula não vamos usar
      /*  val bundle=intent.extras // recuperando os dados da activity Detalhes de restaurantes
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
        */
          //  binding.floatingActionButton.setOnClickListener { finish() }
        binding.btnVoltar2.setOnClickListener { finish() }

        val listaOpcionais= listOf(
            Opcional("Picles","teste",10.0,R.drawable.picles,0),
            Opcional("Queijo","Incremente seu lanche com esse sabor",5.0,R.drawable.queijo,0),
            Opcional("Onion rings","Experimente",18.0,R.drawable.onion_rings,0),
            Opcional("Suco de morango","É uma delicoa",12.0,R.drawable.suco_morango,0),
            Opcional("Batata frita","Incremente seu lanche com esse sabor",5.0,R.drawable.batata_frita1,0),
            Opcional("Refri","Refrescante",9.0,R.drawable.refri1,0),
            Opcional("Água","Incremente seu lanche com esse sabor",5.0,R.drawable.agua1,0)
        )

        val opcionalDePedidoAdapter=OpcionalDePedidoAdapter(listaOpcionais,{
            valorTotalPedido+=it
            binding.textViewValorTotalDoPedido.text=formatarDoubleComVirgula(valorTotalPedido)
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
                binding.textViewValorTotalDoPedido.text=formatarDoubleComVirgula(valorTotalPedido)
            }
        }

        binding.imageViewAdicionarProduto.setOnClickListener {
            qtdProdutosPedidos=binding.textViewQtdProdutosPedidos.text.toString().toInt()+1
            binding.textViewQtdProdutosPedidos.text="$qtdProdutosPedidos"
            valorTotalPedido+=valorProdutoPedido


            binding.textViewValorTotalDoPedido.text= formatarDoubleComVirgula(valorTotalPedido)
        }

        binding.btnConfirmarPedido.setOnClickListener {
           // val intent=Intent(this, PerfilActivity::class.java)

            val intent=Intent(this, ConfirmacaoPedidoActivity::class.java)
            startActivity(intent)
        }
    }
}

public fun formatarDoubleComVirgula(valor: Double): String {
    // formatando valor de saida Ex.(20.00)-> R$ 20,00
    val decimal=((valor-valor.roundToInt())*100).roundToInt()
    if (decimal<10){
        return "R$ ${valor.roundToInt()},0${decimal}"
    } else {
        return "R$ ${valor.roundToInt()},${decimal}"
    }
}
