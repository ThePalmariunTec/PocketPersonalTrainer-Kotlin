package palmariuntec.com.br.pocketpersonaltrainer.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import palmariuntec.com.br.pocketpersonaltrainer.entidade.ExercicioUsuario
import java.sql.Date
import java.util.*

@Dao
interface ExercicioUsuarioDAO {

    @Query("SELECT * FROM exercicio_usuario")
    fun findAll(): List<ExercicioUsuario>

    @Query("SELECT * FROM exercicio_usuario WHERE dtAgedado = :dtAgedado")
    fun findByDate(dtAgedado: Calendar): List<ExercicioUsuario>?

    @Query("SELECT * FROM exercicio_usuario WHERE usuario_id = :usuario_id")
    fun findByUserId(usuario_id: Long): List<ExercicioUsuario>

    @Insert
    fun insert(exerciseUser: ExercicioUsuario)

    @Delete
    fun delete(exerciseUser: ExercicioUsuario)
}