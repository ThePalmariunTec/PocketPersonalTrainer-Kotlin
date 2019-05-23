package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import palmariuntec.com.br.pocketpersonaltrainer.ListViewAdapter
import palmariuntec.com.br.pocketpersonaltrainer.R
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios

class ListaExercicios : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listexercicios, container, false)
    }


}