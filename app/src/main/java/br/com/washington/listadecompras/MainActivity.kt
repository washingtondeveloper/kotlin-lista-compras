package br.com.washington.listadecompras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.com.washington.listadecompras.adapter.ProdutoAdapter
import br.com.washington.listadecompras.utils.produtosGlobal
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val produtosAdapter = ProdutoAdapter(this)


        list_view_produtos.adapter = produtosAdapter

        list_view_produtos.setOnItemLongClickListener {
            adapter: AdapterView<*>?, view: View?, position: Int, id: Long ->

            var item = produtosAdapter.getItem(position)

            produtosAdapter.remove(item)

            true
        }

        btn_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val adapter = list_view_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)

        val	soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }
        val	f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txt_total.text = "TOTAL: ${	f.format(soma)}"
    }
}
