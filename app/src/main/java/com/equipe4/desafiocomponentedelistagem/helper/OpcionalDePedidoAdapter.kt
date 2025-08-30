package com.equipe4.desafiocomponentedelistagem.helper

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.equipe4.desafiocomponentedelistagem.databinding.OpcionalItemLayoutBinding
import com.equipe4.desafiocomponentedelistagem.model.Opcional

class OpcionalDePedidoAdapter(    private val listaOpcionais:List<Opcional>): RecyclerView.Adapter<OpcionalDePedidoAdapter.OpcionalViewHolder>() {

    //private var listaOpcionais= mutableListOf<Opcional>()

    inner class OpcionalViewHolder(val binding: OpcionalItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(opcional: Opcional){ //conectar os dados com a interface
            binding.textViewNomeOpcional.text=opcional.nome
            binding.textViewDescricaoOpcional.text=opcional.descricao
            binding.textViewValorOpcional.text="R$ ${opcional.valor}"
            binding.imageViewOpcional.setImageResource(opcional.fotoId)
            binding.textViewQtdOpcional.text="${opcional.qtd}"
            /*binding.cardView.setOnClickListener {
                clique(mensagem.nome)
                // Toast.makeText(cardView.context,"Olá, ${mensagem.nome}!",Toast.LENGTH_SHORT).show()
            }*/
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