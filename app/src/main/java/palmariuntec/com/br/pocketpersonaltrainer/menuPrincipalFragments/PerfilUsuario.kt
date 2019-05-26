package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments

import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import palmariuntec.com.br.pocketpersonaltrainer.R
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario
import kotlinx.android.synthetic.main.fragment_perfil_usuario.*
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.database.services.UsuarioService
import java.util.*


class PerfilUsuario : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_perfil_usuario, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //img_perfil.setImageURI(Uri.parse(uri))
        txt_user_nome.text = "Gabriel Luis da Silva"
        txt_perfil_pesoperdido.text = "70.00"
    }

    private fun setUsuarioNoFragment(usuario: Usuario) {
        txt_user_nome.text = usuario.nome
        txt_user_pesoatual.text = usuario.peso.toString()
        txt_perfil_pesoperdido.text = "0"
    }
}