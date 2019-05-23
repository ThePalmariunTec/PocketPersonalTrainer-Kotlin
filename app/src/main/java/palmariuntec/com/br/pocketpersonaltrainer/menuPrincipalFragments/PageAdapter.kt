package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                CalendarioTreino()
            }
            1 -> PerfilUsuario()
            else -> {
                return ListaExercicios()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Treinos do Dia"
            1 -> "Meu Perfil"
            else -> {
                return "Lista de exercícios"
            }
        }
    }
}