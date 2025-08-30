package com.equipe4.desafiocomponentedelistagem.helper

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.equipe4.desafiocomponentedelistagem.databinding.OpcionalItemLayoutBinding
import com.equipe4.desafiocomponentedelistagem.model.Opcional
import com.equipe4.desafiocomponentedelistagem.view.DetalhesProdutoActivity

class OpcionalDePedidoAdapter(    private val listaOpcionais:List<Opcional>,
                                  private val clique: (Double)->Unit): RecyclerView.Adapter<OpcionalDePedidoAdapter.OpcionalViewHolder>() {


    private var valorTotalOpcionais:Double=0.0

    inner class OpcionalViewHolder(val binding: OpcionalItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(opcional: Opcional){ //conectar os dados com a interface
            binding.textViewNomeOpcional.text=opcional.nome
            binding.textViewDescricaoOpcional.text=opcional.descricao
            binding.textViewValorOpcional.text="R$ ${opcional.valor}"
            binding.imageViewOpcional.setImageResource(opcional.fotoId)
            binding.textViewQtdOpcional.text="${opcional.qtd}"
            binding.imageViewAddOpcional.setOnClickListener {
                var qtd=binding.textViewQtdOpcional.text.toString().toInt()+1
                binding.textViewQtdOpcional.text="$qtd"
                valorTotalOpcionais+=qtd*opcional.valor
                clique(opcional.valor)
            // Toast.makeText(cardView.context,"Olá, ${mensagem.nome}!",Toast.LENGTH_SHORT).show()

            }
            binding.imageViewMenosOpcional.setOnClickListener {
                var qtd=binding.textViewQtdOpcional.text.toString().toInt()
                if (qtd>=1){
                    binding.textViewQtdOpcional.text="${qtd-1}"
                    valorTotalOpcionais-=opcional.valor
                    clique(opcional.valor/-1)
                }
            }
        }
   }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OpcionalViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        //val itemView=layoutInflater.inflate(R.layout.item_cardview,parent,false) //false pois o proprio rec view ve onde vai colocar item
        val itemView= OpcionalItemLayoutBinding.inflate(layoutInflater,parent,false)

        return OpcionalViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: OpcionalViewHolder,
        position: Int
    ) {
        val opcional=listaOpcionais[position]
        holder.bind(opcional)
    }

    override fun getItemCount(): Int {
        return listaOpcionais.size

    }
}