package br.com.washington.listadecompras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.washington.listadecompras.R
import br.com.washington.listadecompras.model.Produto
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View

        if(convertView != null)
            v = convertView
        else
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)

        val	item = getItem(position)
        val	txt_produto	= v.findViewById<TextView>(R.id.txt_item_produto)
        val	txt_qtd	= v.findViewById<TextView>(R.id.txt_item_qtd)
        val	txt_valor =	v.findViewById<TextView>(R.id.txt_item_valor)
        val	img_produto	= v.findViewById<ImageView>(R.id.img_item_foto)

        val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))

        txt_qtd.text = item.quantidade.toString()
        txt_produto.text = item.nome
        txt_valor.text = format.format(item.valor)

        if	(item.foto != null){
            img_produto.setImageBitmap(item.foto)
        }

        return	v

    }
}