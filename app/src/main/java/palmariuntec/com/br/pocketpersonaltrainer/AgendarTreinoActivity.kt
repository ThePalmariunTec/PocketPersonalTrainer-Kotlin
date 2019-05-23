package palmariuntec.com.br.pocketpersonaltrainer

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import palmariuntec.com.br.pocketpersonaltrainer.entidade.ExercicioUsuario
import kotlinx.android.synthetic.main.fragment_menu_calendario.*

class AgendarTreinoActivity : AppCompatActivity() {

    private var exercicioAgendado: ExercicioUsuario? = null
    private var btnAgendar: View = btnAddTreino

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_agenda_treino)
    }


    private fun getAllTreinosName() {

    }


}