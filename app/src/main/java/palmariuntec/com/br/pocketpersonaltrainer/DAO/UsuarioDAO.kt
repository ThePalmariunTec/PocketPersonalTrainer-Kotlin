package palmariuntec.com.br.pocketpersonaltrainer.DAO

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Query
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Usuario

@Dao
interface UsuarioDAO {

    @Query("SELECT * FROM usuario WHERE id = :id")
    fun getById(id: Long) : Usuario

    @Query("SELECT * FROM usuario WHERE email = :email AND senha = :senha")
    fun getByEmailAndSenha(email: String, senha: String) : Usuario

    @Query("SELECT * FROM usuario")
    fun findALL(): List<Usuario>

    @Insert
    fun insert(user: Usuario)

    @Delete
    fun delete(user: Usuario)
}