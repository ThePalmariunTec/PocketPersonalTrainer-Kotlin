package palmariuntec.com.br.pocketpersonaltrainer

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments.PageAdapter
import kotlinx.android.synthetic.main.activity_principal.*
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.PocketPersonalTrainerRetrofit
import palmariuntec.com.br.pocketpersonaltrainer.utils.AndroidThreads

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val pageAdapter = PageAdapter(supportFragmentManager,
                          FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

        mainLayout.adapter = pageAdapter
        tabsMenu.setupWithViewPager(mainLayout)

        val listView = findViewById<ListView>(R.id.listaExercicio)

        val list = mutableListOf<Exercicios>()

        list.add(Exercicios("Treino Cardiovascular",
            "Quando você faz exercicios cardiovasculares, a energia utilizada pelos músculos que\n" +
                    "estão sendo trabalhados eleva a temperatura\n" +
                    "corporal, o que faz seu coração começar a bater mais rapidamente."))

        list.add(Exercicios("teste 1", "testando..."))
        list.add(Exercicios("teste 2", "testando...."))
        list.add(Exercicios("teste 3", "testando...."))
        list.add(Exercicios("teste 3", "testando...."))

        listView.adapter = ListViewAdapter(this, R.layout.row_lista_exercicio, list)
    }
}