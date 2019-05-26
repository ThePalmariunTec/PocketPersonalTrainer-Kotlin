package palmariuntec.com.br.pocketpersonaltrainer

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments.PageAdapter
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.fragment_listexercicios.*
import kotlinx.android.synthetic.main.fragment_perfil_usuario.*
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.database.services.UsuarioService
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Exercicios
import palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments.ListViewAdapter
import palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments.PerfilUsuario
import palmariuntec.com.br.pocketpersonaltrainer.retrofit2.PocketPersonalTrainerRetrofit
import palmariuntec.com.br.pocketpersonaltrainer.utils.AndroidThreads

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val profile = PerfilUsuario()
        val pageAdapter = PageAdapter(supportFragmentManager,
                          FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        profile.arguments = intent?.extras?.getParcelable("user")

        mainLayout.adapter = pageAdapter
        tabsMenu.setupWithViewPager(mainLayout)
    }

}