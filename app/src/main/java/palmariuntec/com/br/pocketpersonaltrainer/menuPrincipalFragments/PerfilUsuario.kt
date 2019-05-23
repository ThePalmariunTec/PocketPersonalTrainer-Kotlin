package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments

import android.content.Intent.getIntent
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


class PerfilUsuario : Fragment() {
    private val uri = "https://www.facebook.com/photo.php?fbid=2388823477799106&set=a.157617434253066&type=3&theater"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_usuario, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dao = DatabaseManager.getUsuarioDAO()
        val email = activity!!.intent?.extras!!.getString("email")
        val senha = activity!!.intent?.extras!!.getString("senha")
        val user = dao.getByEmailAndSenha(email,senha)

        setUsuarioNoFragment(user)
    }

    private fun setUsuarioNoFragment(usuario: Usuario) {
        img_perfil.setImageBitmap(BitmapFactory.decodeFile(usuario.URIfotoPerfil))
        txt_user_nome.text = usuario.nome
        txt_user_pesoatual.text = usuario.peso.toString()
        txt_perfil_pesoperdido.text = "0"
    }

}