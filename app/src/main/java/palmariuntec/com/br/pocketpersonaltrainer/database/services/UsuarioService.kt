package palmariuntec.com.br.pocketpersonaltrainer.database.services
import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario

object UsuarioService {

    fun insert(user:Usuario){
        val dao = DatabaseManager.getUsuarioDAO()
        dao.insert(user)
    }

    fun delete(user: Usuario){
        val dao = DatabaseManager.getUsuarioDAO()
        dao.delete(user)
    }

    fun getUserByEmailSenha(email: String, senha: String): Usuario?{
        val dao = DatabaseManager.getUsuarioDAO()
        val user = dao.getByEmailAndSenha(email, senha)
        return user;
    }

    fun getUser(): Usuario{
        val dao = DatabaseManager.getUsuarioDAO()
        val user = dao.findALL()
        return  user
    }
}