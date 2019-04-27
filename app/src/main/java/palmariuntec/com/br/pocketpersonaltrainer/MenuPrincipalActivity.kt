package palmariuntec.com.br.pocketpersonaltrainer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import palmariuntec.com.br.pocketpersonaltrainer.entidade.ExercicioUsuario
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments.PageAdapter
import kotlinx.android.synthetic.main.activity_principal.*
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import java.util.Calendar

class MenuPrincipalActivity : AppCompatActivity() {

    private var listExercicioUsuario: List<ExercicioUsuario>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val pageAdapter = PageAdapter(supportFragmentManager)

        mainLayout.adapter = pageAdapter
        tabsMenu.setupWithViewPager(mainLayout)

        var user:Usuario? = getUsuarioBancoByEmailSenha()
    }

    private fun getUsuarioBancoByEmailSenha(email: String, senha:String):Usuario? {
        val dao = DatabaseManager.getUsuarioDAO()
        val user = dao.getByEmailAndSenha(email, senha)
         return user
    }


    private fun listaTodosTreinosAgendados() {
        val dao = DatabaseManager.getExercicioUsuarioDAO()
        listExercicioUsuario = dao.findByDate(Calendar.DATE)
    }
}