package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import palmariuntec.com.br.pocketpersonaltrainer.R
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios
import kotlinx.android.synthetic.main.fragment_listexercicios.*
import palmariuntec.com.br.pocketpersonaltrainer.PocketPersonalTrainer

class ListaExercicios : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_listexercicios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()

    }

    private fun setList(){
        val listView = listaExercicio

        val list = mutableListOf<Exercicios>()

        val exercise = Exercicios(null, "Treino Cardiovascular",
            "Quando você faz exercicios cardiovasculares, a energia utilizada pelos músculos que\n" +
                    "estão sendo trabalhados eleva a temperatura\n" +
                    "corporal, o que faz seu coração começar a bater mais rapidamente.")

        val exerciseOne = Exercicios(null, "Teste",
            "testeando...")

        val exerciseTwo = Exercicios(null, "Teste Again",
            "continuanado testeando...")

        list.add(exercise)

        list.add(exerciseOne)
        list.add(exerciseTwo)

        listView.adapter = ListViewAdapter(PocketPersonalTrainer.getInstance().applicationContext,
            R.layout.row_lista_exercicio, list)

}