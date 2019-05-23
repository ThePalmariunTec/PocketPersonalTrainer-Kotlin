package palmariuntec.com.br.pocketpersonaltrainer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios

class ListViewAdapter(var mCtx: Context, var resource:Int, var items:List<Exercicios>)
    : ArrayAdapter<Exercicios>( mCtx , resource , items ){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        var nome : TextView = view.findViewById(R.id.exercicio_nome)
        var descricao : TextView = view.findViewById(R.id.exercicio_desc)


        var exercicio : Exercicios = items[position]

        nome.text = exercicio.nome
        descricao.text = exercicio.desc


        return view
    }

}